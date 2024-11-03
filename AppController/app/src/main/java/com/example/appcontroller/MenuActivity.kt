package com.example.appcontroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.appcontroller.models.User

class MenuActivity : ComponentActivity() {
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        user = (intent.getSerializableExtra("CURRENT_USER") as? User)!!

        val btVend: Button = findViewById(R.id.bt_vend)
        btVend.setOnClickListener {
            val intent = Intent(this, VendActivity::class.java)
            intent.putExtra("CURRENT_USER", user)
            startActivity(intent)
        }

        val btCad: Button = findViewById(R.id.bt_cad)
        btCad.setOnClickListener{
            val intent = Intent(this, CadActivity::class.java)
            intent.putExtra("CURRENT_USER", user)
            startActivity(intent)
        }

        val btRelat : Button = findViewById(R.id.bt_relat)
        btRelat.setOnClickListener {
            val intent = Intent(this, RelatActivity::class.java)
            intent.putExtra("CURRENT_USER", user)
            startActivity(intent)
        }
    }
}