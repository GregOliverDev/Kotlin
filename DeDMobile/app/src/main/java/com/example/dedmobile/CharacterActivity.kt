package com.example.dedmobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.ComponentActivity
import com.example.dedmobile.models.character.Character
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class CharacterActivity : ComponentActivity() {
    private lateinit var player: Player
    private lateinit var character: Character

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        var indexImage = 1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        val player = intent.getSerializableExtra("CURRENT_USER") as? Player

        val characterImage: ImageView = findViewById(R.id.character_image)

        val genderSpinner: Spinner = findViewById(R.id.gender_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        val myButton: Button = findViewById(R.id.bt_next)
        myButton.setOnClickListener {
            val intent = Intent(this, AttributeActivity::class.java)
            startActivity(intent)
        }

        val characterImages = arrayOf(
            R.drawable.character_01,
            R.drawable.character_02,
            R.drawable.character_03,
            R.drawable.character_04
        )

        val btLeft: ImageButton = findViewById(R.id.left)
        myButton.setOnClickListener {
            indexImage -= 1
            characterImage.setImageResource(characterImages[indexImage])
        }

        val btRight: ImageButton = findViewById(R.id.right)
        myButton.setOnClickListener {
            indexImage += 1
            characterImage.setImageResource(characterImages[indexImage])
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val age: EditText = findViewById(R.id.age_character)
        val gender: Spinner = findViewById(R.id.gender_spinner)
        val nameCharacter: EditText = findViewById(R.id.name_character)
        val physicalDescription: EditText = findViewById(R.id.description)

        val ageValue: Int = age.text.toString().toIntOrNull() ?: 0

        character = Character(ageValue, gender.selectedItem.toString(), indexImage, nameCharacter.text.toString(),physicalDescription.text.toString())

    }
}