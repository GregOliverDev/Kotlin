package com.example.dedmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)
        myButton.setOnClickListener {
            val intent = Intent(this, CharacterActivity::class.java)
            intent.putExtra("LOGIN_NAME", "valorDoLogin") // Substitua por um valor real ou variável
            startActivity(intent)
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}
