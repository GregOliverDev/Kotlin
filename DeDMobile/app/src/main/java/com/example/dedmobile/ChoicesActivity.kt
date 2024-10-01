package com.example.dedmobile

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity
import com.example.dedmobile.models.character.Character
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class ChoicesActivity: ComponentActivity() {
    private lateinit var player: Player
    private lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choices)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        player = (intent.getSerializableExtra("CURRENT_USER") as? Player)!!
        character = (intent.getSerializableExtra("CURRENT_CHARACTER") as? Character)!!

        val raceSpinner: Spinner = findViewById(R.id.race)
        val adapterRace = ArrayAdapter.createFromResource(
            this,
            R.array.race_options,
            android.R.layout.simple_spinner_item
        )
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        raceSpinner.adapter = adapterRace

        val subRaceSpinner: Spinner = findViewById(R.id.sub_race)
        val adapterSubRace = ArrayAdapter.createFromResource(
            this,
            R.array.sub_race_options,
            android.R.layout.simple_spinner_item
        )
        adapterSubRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subRaceSpinner.adapter = adapterSubRace

        val classeCharacterSpinner: Spinner = findViewById(R.id.classe_character)
        val adapterClasseCharacter = ArrayAdapter.createFromResource(
            this,
            R.array.classe_character_options,
            android.R.layout.simple_spinner_item
        )
        adapterClasseCharacter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        classeCharacterSpinner.adapter = adapterClasseCharacter

    }
}