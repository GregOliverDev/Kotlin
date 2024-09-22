package com.example.dedmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class CharacterActivity : ComponentActivity() {
    private lateinit var player: Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        val player = intent.getSerializableExtra("CURRENT_USER") as? Player

        val characterImage: ImageView = findViewById(R.id.character_image)
        characterImage.setImageResource(R.drawable.border_with_character)

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
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}