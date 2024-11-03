package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.Ability
import com.example.dedmobile.models.character.Attribute
import com.example.dedmobile.models.character.ClassCharacter
import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.Level
import com.example.dedmobile.models.character.Mod
import com.example.dedmobile.models.character.Race
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.dice.Dice

class SheetDeDController(context: Context) {
    private val databaseHelper = Database(context)
    private lateinit var characterController: CharacterController
    private lateinit var abilityController: AbilityController
    private lateinit var attributeController: AttributeController
    private lateinit var languageController: LanguageController
    private lateinit var modController: ModController
    private lateinit var specialFeatureController: SpecialFeatureController

    fun insertSheet(sheetDeD: SheetDeD, idCharacter: Int): Long {
        val db = databaseHelper.writableDatabase
        val values = ContentValues().apply {
            put("amountDiceLive", sheetDeD.amountDiceLive)
            put("race", sheetDeD.race.nameRace)
            put("idCharacter", idCharacter)
            put("classeCharacter", sheetDeD.classCharacter.nameClassCharacter)
            put("currentHitPoints", sheetDeD.currentHitPoints)
            put("diceLive", sheetDeD.diceLive.type)
            put("displacement", sheetDeD.displacement)
            put("hitPoints", sheetDeD.hitPoints)
            put("level", sheetDeD.level.getLevel())
            put("subRace", sheetDeD.subRace.nameRace)
            put("temporaryHitPoints", sheetDeD.temporaryHitPoints)
        }

        return db.insert("sheets", null, values)
    }

    fun getSheet(context: Context, id: Int): SheetDeD? {
        abilityController = AbilityController(context)
        attributeController = AttributeController(context)
        characterController = CharacterController(context)
        languageController = LanguageController(context)
        modController = ModController(context)
        specialFeatureController = SpecialFeatureController(context)

        val db = databaseHelper.readableDatabase

        val cursor = db.query(
            "sheets",
            arrayOf(
                "id",
                "amountDiceLive",
                "race",
                "idCharacter",
                "classeCharacter",
                "currentHitPoints",
                "diceLive",
                "displacement",
                "hitPoints",
                "level",
                "subRace",
                "temporaryHitPoints"
            ),
            "id = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            val idSheetDeD = cursor.getInt(cursor.getColumnIndexOrThrow("id"))

            val temporaryHitPoints =
                cursor.getInt(cursor.getColumnIndexOrThrow("temporaryHitPoints"))
            val raceAux = cursor.getString(cursor.getColumnIndexOrThrow("race"))
            val idCharacter = cursor.getInt(cursor.getColumnIndexOrThrow("idCharacter"))
            val classeCharacterAux =
                cursor.getString(cursor.getColumnIndexOrThrow("classeCharacter"))
            val levelAux = cursor.getInt(cursor.getColumnIndexOrThrow("level"))
            val subRaceAux = cursor.getString(cursor.getColumnIndexOrThrow("subRace"))

            val abilities: List<Ability> = abilityController.getAbilities()
            val attributes: List<Attribute> = attributeController.getAttributes(idSheetDeD)
            val amountDiceLive = cursor.getInt(cursor.getColumnIndexOrThrow("amountDiceLive"))
            val character = characterController.getCharacter(idCharacter)
            val currentHitPoints = cursor.getInt(cursor.getColumnIndexOrThrow("currentHitPoints"))
            val diceLive = Dice(cursor.getString(cursor.getColumnIndexOrThrow("diceLive")))
            val displacement = cursor.getInt(cursor.getColumnIndexOrThrow("displacement"))
            val hitPoints = cursor.getInt(cursor.getColumnIndexOrThrow("hitPoints"))
            val languages: List<Language> = languageController.getLanguages(idSheetDeD)
            val level = Level(levelAux, 0)
            val mods: List<Mod> = modController.getMods(idSheetDeD)
            val specialFeatures: List<SpecialFeature> =
                specialFeatureController.getSpecialFeatures(idSheetDeD)
            val race = Race(raceAux)
            val subRace = Race(subRaceAux)
            val classeCharacter = ClassCharacter(classeCharacterAux, "No Path")

            val sheetDeD = character?.let {
                SheetDeD(
                    abilities,
                    attributes,
                    amountDiceLive,
                    race,
                    it,
                    classeCharacter,
                    currentHitPoints,
                    diceLive,
                    displacement,
                    hitPoints,
                    idSheetDeD,
                    languages,
                    level,
                    mods,
                    subRace,
                    specialFeatures,
                    temporaryHitPoints
                )
            }


            cursor.close()
            sheetDeD
        } else {
            cursor.close()
            null
        }
    }

    fun updateSheet(sheetDeD: SheetDeD) {
        val db = databaseHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("level", sheetDeD.level.getLevel())
            put("hitPoints", sheetDeD.hitPoints)
            put("amountDiceLive", sheetDeD.amountDiceLive)
            put("currentHitPoints", sheetDeD.currentHitPoints)
        }

        db.update("sheets", contentValues, "id = ?", arrayOf(sheetDeD.id.toString()))
        db.close()
    }

    fun getMaxId(): Int? {
        val db = databaseHelper.readableDatabase
        var maxId: Int? = null
        val query = "SELECT MAX(id) FROM sheets"

        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            maxId = cursor.getInt(0)
        }
        cursor.close()
        db.close()

        return maxId
    }
}