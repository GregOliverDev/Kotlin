package com.example.dedmobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dedmobile.data.players.PlayerController
import com.example.dedmobile.models.character.Character
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private lateinit var player: Player
    private lateinit var character: Character
    private lateinit var playerController: PlayerController

    override fun onCreate(savedInstanceState: Bundle?) {
        playerController = PlayerController(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val nameUser: EditText = findViewById(R.id.name_character)
        val passwordUser: EditText = findViewById(R.id.password_character)

        val btRegister: Button = findViewById(R.id.register)
        btRegister.setOnClickListener {
            val namePlayer = nameUser.text.toString()
            val passwordPlayer = passwordUser.text.toString()
            if (playerController.insertPlayer(namePlayer, passwordPlayer)) {
                Toast.makeText(this, "Usuário inserido com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuário ja existente!", Toast.LENGTH_SHORT).show()
            }
        }

        val btEntrar: Button = findViewById(R.id.entrar)
        btEntrar.setOnClickListener {
            val namePlayer: String = nameUser.text.toString()
            val passwordPlayer: String = passwordUser.text.toString()

            val findPlayer = playerController.getPlayer(namePlayer, passwordPlayer)
            if (findPlayer == null) {
                val toast = Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                player = findPlayer
                character = Character(0, "Masculino", 0, "", "")
                val intent = Intent(this, CharacterActivity::class.java)
                intent.putExtra("CURRENT_USER", player)
                intent.putExtra("CURRENT_CHARACTER", character)
                startActivity(intent)
            }
        }
    }
}

