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
import com.example.dedmobile.models.player.FindPlayer
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private lateinit var player: Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameUser: EditText = findViewById(R.id.name_player)
        val passwordUser: EditText = findViewById(R.id.password_player)
        val myButton: Button = findViewById(R.id.myButton)

        myButton.setOnClickListener {
            val namePlayer = nameUser.text.toString()
            val passwordPlayer = passwordUser.text.toString()
            val find = FindPlayer()

            if(find.findPlayerByName(namePlayer,passwordPlayer) != null){

                player = find.findPlayerByName(namePlayer,passwordPlayer)!!
                val intent = Intent(this, CharacterActivity::class.java)
                intent.putExtra("CURRENT_USER", player)
                startActivity(intent)

            }else{
                val toast = Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            }
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}

