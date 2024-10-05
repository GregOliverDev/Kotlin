package com.example.dedmobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dedmobile.models.character.Character
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class CharacterActivity : ComponentActivity() {
    private lateinit var player: Player
    private lateinit var character: Character

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        player = (intent.getSerializableExtra("CURRENT_USER") as? Player)!!
        character = (intent.getSerializableExtra("CURRENT_CHARACTER") as? Character)!!
        var indexImage = character.indexImage
        val characterImage: ImageView = findViewById(R.id.character_image)
        val age: EditText = findViewById(R.id.age_character)
        val gender: Spinner = findViewById(R.id.gender_spinner)
        val nameCharacter: EditText = findViewById(R.id.name_character)
        val physicalDescription: EditText = findViewById(R.id.description)

        val genderSpinner: Spinner = findViewById(R.id.gender_spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        val btNext: Button = findViewById(R.id.bt_next)
        btNext.setOnClickListener {

            character.age = age.text.toString().toIntOrNull() ?: 0
            character.gender = gender.selectedItem.toString()
            character.indexImage = indexImage
            character.nameCharacter = nameCharacter.text.toString()
            character.physicalDescription = physicalDescription.text.toString()

            if (character.nameCharacter.isNotBlank()) {
                if (character.physicalDescription.isNotBlank()) {
                    if (character.age != 0) {
                        val intent = Intent(this, AttributeActivity::class.java)
                        intent.putExtra("CURRENT_USER", player)
                        intent.putExtra("CURRENT_CHARACTER", character)
                        startActivity(intent)
                    } else {
                        val toast =
                            Toast.makeText(this, "Digite o campo Idade!", Toast.LENGTH_SHORT)
                        toast.show()

                        Handler(Looper.getMainLooper()).postDelayed({
                            toast.cancel()
                        }, 5000)
                    }
                } else {
                    val toast = Toast.makeText(this, "Digite a descrição!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                }
            } else {
                val toast = Toast.makeText(this, "Digite o Nome!", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            }

        }

        val characterImages = arrayOf(
            R.drawable.character_01,
            R.drawable.character_02,
            R.drawable.character_03,
            R.drawable.character_04
        )

        val btLeft: ImageButton = findViewById(R.id.left)
        btLeft.setOnClickListener {
            if (indexImage > 0) {
                indexImage -= 1
                characterImage.setImageResource(characterImages[indexImage])
            }
        }

        val btRight: ImageButton = findViewById(R.id.right)
        btRight.setOnClickListener {
            if (indexImage < characterImages.size - 1) {
                indexImage += 1
                characterImage.setImageResource(characterImages[indexImage])
            }
        }

        nameCharacter.setText(character.nameCharacter)
        physicalDescription.setText(character.physicalDescription)
        age.setText(character.age.toString())
        val position = adapter.getPosition(character.gender)
        genderSpinner.setSelection(position)
        characterImage.setImageResource(characterImages[indexImage])

    }
}