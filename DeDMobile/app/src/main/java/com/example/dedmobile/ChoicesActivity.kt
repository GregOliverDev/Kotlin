package com.example.dedmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.view.setPadding
import com.example.dedmobile.models.character.Attribute
import com.example.dedmobile.models.character.Character
import com.example.dedmobile.models.character.ClassCharacter
import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.Level
import com.example.dedmobile.models.character.Mod
import com.example.dedmobile.models.character.Race
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.abilities.DefineAbilities
import com.example.dedmobile.models.character.attributes.DefineAttributes
import com.example.dedmobile.models.character.classCharacters.DefineClassCharacter
import com.example.dedmobile.models.character.classCharacters.IClassCharacter
import com.example.dedmobile.models.character.classCharacters.barbarian.Barbarian
import com.example.dedmobile.models.character.classCharacters.cleric.Cleric
import com.example.dedmobile.models.character.classCharacters.druid.Druid
import com.example.dedmobile.models.character.classCharacters.monk.Monk
import com.example.dedmobile.models.character.classCharacters.paladin.Paladin
import com.example.dedmobile.models.character.classCharacters.rogue.Rogue
import com.example.dedmobile.models.character.classCharacters.warrior.Warrior
import com.example.dedmobile.models.character.classCharacters.wizard.Wizard
import com.example.dedmobile.models.character.classCharacters.bard.Bard
import com.example.dedmobile.models.character.modifiers.DefineMod
import com.example.dedmobile.models.character.races.DefineRaceCharacter
import com.example.dedmobile.models.character.races.IRace
import com.example.dedmobile.models.character.races.NoSubRace
import com.example.dedmobile.models.character.races.dwarfs.Dwarf
import com.example.dedmobile.models.character.races.dwarfs.HillDwarf
import com.example.dedmobile.models.character.races.dwarfs.MountainDwarf
import com.example.dedmobile.models.character.races.elves.Drow
import com.example.dedmobile.models.character.races.elves.Elf
import com.example.dedmobile.models.character.races.elves.HighElf
import com.example.dedmobile.models.character.races.elves.MoonElf
import com.example.dedmobile.models.character.races.elves.WoodElf
import com.example.dedmobile.models.character.races.gnomes.ForestGnome
import com.example.dedmobile.models.character.races.gnomes.Gnome
import com.example.dedmobile.models.character.races.gnomes.RockGnome
import com.example.dedmobile.models.character.races.halflings.Halfling
import com.example.dedmobile.models.character.races.halflings.LightfootHalfling
import com.example.dedmobile.models.character.races.halflings.StoutHalfling
import com.example.dedmobile.models.character.races.humans.HalfElves
import com.example.dedmobile.models.character.races.humans.HalfOrcs
import com.example.dedmobile.models.character.races.humans.Human
import com.example.dedmobile.models.character.races.tieflings.Tiefling
import com.example.dedmobile.models.dice.Dice
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class ChoicesActivity : ComponentActivity() {
    private lateinit var player: Player
    private lateinit var character: Character
    private lateinit var attributes: List<Attribute>
    private lateinit var mods: List<Mod>
    private lateinit var sheetDeD: SheetDeD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choices)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val screen0 : LinearLayout = findViewById(R.id.screen0)
        val screen1 : LinearLayout = findViewById(R.id.screen1)
        screen1.visibility = View.GONE
        player = (intent.getSerializableExtra("CURRENT_USER") as? Player)!!
        character = (intent.getSerializableExtra("CURRENT_CHARACTER") as? Character)!!
        val receivedAttributes = intent.getParcelableArrayExtra("CURRENT_ATTRIBUTES") as? Array<*>
        val attributesReturn = receivedAttributes?.filterIsInstance<Attribute>() ?: emptyList()
        val defineMod = DefineMod()
        val language = Language("")

        attributes = attributesReturn.ifEmpty {
            DefineAttributes().defineAttributes().toList()
        }

        val receivedMod = intent.getSerializableExtra("CURRENT_MOD") as? Array<*>
        val modReturn = receivedMod?.filterIsInstance<Mod>() ?: emptyList()

        mods = modReturn.ifEmpty {
            defineMod.defineMods()
        }

        val race = Race("New Instence Race")
        var iRace: IRace = Dwarf()
        val subRace = Race("New Instence Sub Race")
        var iSubRace: IRace = NoSubRace()
        val classCharacter = ClassCharacter("New Instence Class", "No Path")
        var iClassCharacter: IClassCharacter = Barbarian()
        val specialFeature: List<SpecialFeature> = listOf()

        sheetDeD = SheetDeD(
            DefineAbilities().defineAbilities().toList(),
            DefineAttributes().defineAttributes().toList(),
            0,
            race,
            character,
            classCharacter,
            0,
            Dice(""),
            0,
            0,
            0,
            listOf(Language("Comun")),
            Level(0, 0),
            defineMod.defineMods(),
            subRace,
            specialFeature,
            0
        )

        sheetDeD.attributes = attributes.map { it.copy() }

        val live: TextView = findViewById(R.id.live)

        fun updateTextLive(){
            val calcLive = 12 + mods[2].valueMod
            live.text = calcLive.toString()
        }

        updateTextLive()

        val valueMod0: TextView = findViewById(R.id.value_mod_0)
        val valueMod1: TextView = findViewById(R.id.value_mod_1)
        val valueMod2: TextView = findViewById(R.id.value_mod_2)
        val valueMod3: TextView = findViewById(R.id.value_mod_3)
        val valueMod4: TextView = findViewById(R.id.value_mod_4)
        val valueMod5: TextView = findViewById(R.id.value_mod_5)

        fun updateMod(){
            mods = defineMod.updateMod(mods, attributes[0], 0)
            mods = defineMod.updateMod(mods, attributes[1], 1)
            mods = defineMod.updateMod(mods, attributes[2], 2)
            mods = defineMod.updateMod(mods, attributes[3], 3)
            mods = defineMod.updateMod(mods, attributes[4], 4)
            mods = defineMod.updateMod(mods, attributes[5], 5)

            valueMod0.text = mods[0].valueMod.toString()
            valueMod1.text = mods[1].valueMod.toString()
            valueMod2.text = mods[2].valueMod.toString()
            valueMod3.text = mods[3].valueMod.toString()
            valueMod4.text = mods[4].valueMod.toString()
            valueMod5.text = mods[5].valueMod.toString()
            updateTextLive()
        }

        updateMod()

        val characterImage: ImageView = findViewById(R.id.character_image)
        val characterImages = arrayOf(
            R.drawable.character_01,
            R.drawable.character_02,
            R.drawable.character_03,
            R.drawable.character_04
        )

        characterImage.setImageResource(characterImages[sheetDeD.characterSheet.indexImage])

        val valueAttri0: TextView = findViewById(R.id.value_attribute_0)
        val valueAttri1: TextView = findViewById(R.id.value_attribute_1)
        val valueAttri2: TextView = findViewById(R.id.value_attribute_2)
        val valueAttri3: TextView = findViewById(R.id.value_attribute_3)
        val valueAttri4: TextView = findViewById(R.id.value_attribute_4)
        val valueAttri5: TextView = findViewById(R.id.value_attribute_5)

        fun updateTextAttribute() {
            valueAttri0.text = attributes[0].valueAttribute.toString()
            valueAttri1.text = attributes[1].valueAttribute.toString()
            valueAttri2.text = attributes[2].valueAttribute.toString()
            valueAttri3.text = attributes[3].valueAttribute.toString()
            valueAttri4.text = attributes[4].valueAttribute.toString()
            valueAttri5.text = attributes[5].valueAttribute.toString()
        }

        updateTextAttribute()

        val textLanguage: TextView = findViewById(R.id.language_text)
        val languageAdd: Spinner = findViewById(R.id.language)
        val adapterLanguage = ArrayAdapter.createFromResource(
            this,
            R.array.language_add,
            android.R.layout.simple_spinner_item
        )
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_item)
        languageAdd.adapter = adapterLanguage

        val textSubRace: TextView = findViewById(R.id.text_sub_race)
        val raceSpinner: Spinner = findViewById(R.id.race)
        val adapterRace = ArrayAdapter.createFromResource(
            this,
            R.array.race_options,
            android.R.layout.simple_spinner_item
        )
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        raceSpinner.adapter = adapterRace

        val classeCharacterSpinner: Spinner = findViewById(R.id.classe_character)
        val adapterClasseCharacter = ArrayAdapter.createFromResource(
            this,
            R.array.classe_character_options,
            android.R.layout.simple_spinner_item
        )
        adapterClasseCharacter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        classeCharacterSpinner.adapter = adapterClasseCharacter

        val subRaceSpinner: Spinner = findViewById(R.id.sub_race)

        fun updateSubRaceSpinner(selectedRace: String) {
            val subRaceArrayId = when (selectedRace) {
                "Anão" -> R.array.sub_race_dwarfs
                "Elfo" -> R.array.sub_race_elves
                "Gnomo" -> R.array.sub_race_gnomes
                "Halfling" -> R.array.sub_race_halflings
                else -> null
            }
            if (subRaceArrayId != null) {
                subRaceSpinner.visibility = View.VISIBLE
                textSubRace.visibility = View.VISIBLE
                languageAdd.visibility = View.GONE
                textLanguage.visibility = View.GONE
                val adapterSubRace = ArrayAdapter.createFromResource(
                    this,
                    subRaceArrayId,
                    android.R.layout.simple_spinner_item
                )
                adapterSubRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                subRaceSpinner.adapter = adapterSubRace
            } else {
                subRaceSpinner.visibility = View.GONE
                textSubRace.visibility = View.GONE
                iSubRace = NoSubRace()
                if (selectedRace == "Humano" || selectedRace == "Meio-Elvo"){
                    languageAdd.visibility = View.VISIBLE
                    textLanguage.visibility = View.VISIBLE
                }else{
                    languageAdd.visibility = View.GONE
                    textLanguage.visibility = View.GONE
                }
            }
        }

        fun selectRace(selectedRace: String) {
            attributes = sheetDeD.attributes.map { it.copy() }
            when (selectedRace) {
                "Anão" -> iRace = Dwarf()
                "Elfo" -> iRace = Elf()
                "Gnomo" -> iRace = Gnome()
                "Halfling" -> iRace = Halfling()
                "Humano" -> {
                    iRace = Human()
                    attributes[0].valueAt += 1
                    attributes[1].valueAt += 1
                    attributes[2].valueAt += 1
                    attributes[3].valueAt += 1
                    attributes[4].valueAt += 1
                    attributes[5].valueAt += 1
                }

                "Meio-Elvo" -> {
                    iRace = HalfElves()
                    attributes[5].valueAt += 2
                }

                "Meio-Orc" -> {
                    iRace = HalfOrcs()
                    attributes[0].valueAt += 2
                    attributes[2].valueAt += 1
                }

                "Tiefling" -> {
                    iRace = Tiefling()
                    attributes[3].valueAt += 1
                    attributes[5].valueAt += 2
                }

                else -> iRace = Dwarf()
            }
            updateTextAttribute()
            updateMod()
        }

        fun selectSubRace(selectedSubRace: String) {
            attributes = sheetDeD.attributes.map { it.copy() }
             when (selectedSubRace) {
                "Anão da Colina" -> {
                    iSubRace = HillDwarf()
                    attributes[2].valueAt +=2
                    attributes[4].valueAt +=1
                }
                "Anão da Montanha" -> {
                    iSubRace = MountainDwarf()
                    attributes[0].valueAt +=2
                    attributes[2].valueAt +=2
                }
                "Elfo das Trevas" -> {
                    iSubRace = Drow()
                    attributes[1].valueAt +=2
                    attributes[5].valueAt +=1
                }
                "Alto Elfo" -> {
                    iSubRace = HighElf()
                    attributes[1].valueAt +=2
                    attributes[3].valueAt +=1
                }
                "Elfo da Lua" -> {
                    iSubRace = MoonElf()
                    attributes[1].valueAt +=2
                    attributes[5].valueAt +=1
                }
                "Elfo da Floresta" -> {
                    iSubRace = WoodElf()
                    attributes[1].valueAt +=2
                    attributes[4].valueAt +=1
                }
                "Gnomo da Floresta" -> {
                    iSubRace = ForestGnome()
                    attributes[3].valueAt +=2
                    attributes[1].valueAt +=1
                }
                "Gnomo da Rocha" -> {
                    iSubRace = RockGnome()
                    attributes[3].valueAt +=2
                    attributes[2].valueAt +=1
                }
                "Halfling Robusto" -> {
                    iSubRace = StoutHalfling()
                    attributes[1].valueAt +=2
                    attributes[2].valueAt +=1
                }
                "Halfling Pés-Leves" -> {
                    iSubRace = LightfootHalfling()
                    attributes[1].valueAt +=2
                    attributes[5].valueAt +=1
                }
                else -> iSubRace = NoSubRace()
            }
            updateTextAttribute()
            updateMod()
        }

        fun selectClass(selectedClass: String) {
            iClassCharacter = when (selectedClass) {
                "Bárbaro" -> Barbarian()
                "Bardo" -> Bard()
                "Clérigo" -> Cleric()
                "Druida" -> Druid()
                "Guerreiro" -> Warrior()
                "Ladino" -> Rogue()
                "Mago" -> Wizard()
                "Monge" -> Monk()
                "Paladino" -> Paladin()
                else -> Barbarian()
            }
        }

        languageAdd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedLanguage = parent.getItemAtPosition(position).toString()
                language.nameLanguage = selectedLanguage
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                language.nameLanguage = ""
            }
        }

        raceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedRace = parent.getItemAtPosition(position).toString()
                updateSubRaceSpinner(selectedRace)
                selectRace(selectedRace)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        subRaceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedSubRace = parent.getItemAtPosition(position).toString()
                selectSubRace(selectedSubRace)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        classeCharacterSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedClass = parent.getItemAtPosition(position).toString()
                    selectClass(selectedClass)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }

        fun updateScreen1(){

            val attributes0: TextView = findViewById(R.id.attribute0)
            val attributes1: TextView = findViewById(R.id.attribute1)
            val attributes2: TextView = findViewById(R.id.attribute2)
            val attributes3: TextView = findViewById(R.id.attribute3)
            val attributes4: TextView = findViewById(R.id.attribute4)
            val attributes5: TextView = findViewById(R.id.attribute5)

            var text = "Força: " + sheetDeD.attributes[0].valueAttribute.toString()
            attributes0.text = text
            text = "Destreza: " + sheetDeD.attributes[1].valueAttribute.toString()
            attributes1.text = text
            text = "Constituição: " + sheetDeD.attributes[2].valueAttribute.toString()
            attributes2.text = text
            text = "Inteligência: " + sheetDeD.attributes[3].valueAttribute.toString()
            attributes3.text = text
            text = "Sabedoria: " + sheetDeD.attributes[4].valueAttribute.toString()
            attributes4.text = text
            text = "Carisma: " + sheetDeD.attributes[5].valueAttribute.toString()
            attributes5.text = text

            val nameCharacter: TextView = findViewById(R.id.name_character)
            text = sheetDeD.characterSheet.nameCharacter
            nameCharacter.text = text

            val ageCharacter: TextView = findViewById(R.id.age_character)
            text = sheetDeD.characterSheet.age.toString()
            ageCharacter.text = text

            val descriptorCharacter: TextView = findViewById(R.id.description_character)
            text = sheetDeD.characterSheet.physicalDescription
            descriptorCharacter.text = text

            val raceCharacter: TextView = findViewById(R.id.race_text)
            text = sheetDeD.race.nameRace
            raceCharacter.text = text

            val subRaceCharacter: TextView = findViewById(R.id.sub_race_text)
            text = sheetDeD.subRace.nameRace
            subRaceCharacter.text = text

            val classeCharacter: TextView = findViewById(R.id.classe_character_text)
            text = sheetDeD.classCharacter.nameClassCharacter
            classeCharacter.text = text

            val liveCharacter: TextView = findViewById(R.id.live_text)
            text = sheetDeD.hitPoints.toString()
            liveCharacter.text = text

            val genText : TextView = findViewById(R.id.gen_text)
            text = sheetDeD.characterSheet.gender
            genText.text = text

            val border : LinearLayout = findViewById(R.id.border)
            border.setBackgroundResource(R.drawable.border_with_save)
        }

        val btNext: Button = findViewById(R.id.bt_next)
        btNext.setOnClickListener {
            sheetDeD.mods = mods
            val defineRaceCharacter = DefineRaceCharacter(iRace, sheetDeD)
            val defineSubRaceCharacter = DefineRaceCharacter(iSubRace, sheetDeD)
            val defineClassCharacter = DefineClassCharacter(iClassCharacter, sheetDeD)
            sheetDeD = defineRaceCharacter.createRace()
            sheetDeD = defineSubRaceCharacter.createRace()
            sheetDeD = defineClassCharacter.createClassCharacter()
            sheetDeD.hitPoints = live.text.toString().toIntOrNull() ?: 0

            if(textLanguage.visibility == View.VISIBLE){
                val languagesAux = sheetDeD.languages.toMutableList()
                languagesAux.add(Language(language.nameLanguage))

                sheetDeD.languages = languagesAux.toList()
            }
            screen0.visibility = View.GONE
            updateScreen1()
            screen1.visibility = View.VISIBLE
        }

        val btBack: Button = findViewById(R.id.bt_back)
        btBack.setOnClickListener {
            val intent = Intent(this, AttributeActivity::class.java)
            intent.putExtra("CURRENT_USER", player)
            intent.putExtra("CURRENT_CHARACTER", character)
            startActivity(intent)
        }
    }
}