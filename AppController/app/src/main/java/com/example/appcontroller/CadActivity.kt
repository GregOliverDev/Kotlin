package com.example.appcontroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.appcontroller.models.User

class CadActivity: ComponentActivity() {
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_cad)
        user = (intent.getSerializableExtra("CURRENT_USER") as? User)!!

        val btCadProd: Button = findViewById(R.id.bt_cad_prod)
        btCadProd.setOnClickListener{
            val intent = Intent(this, CadProdActivity::class.java)
            intent.putExtra("CURRENT_USER", user)
            startActivity(intent)
        }
        val btCadServ: Button = findViewById(R.id.bt_cad_serv)
        btCadServ.setOnClickListener{
            val intent = Intent(this, CadServActivity::class.java)
            intent.putExtra("CURRENT_USER", user)
            startActivity(intent)
        }
    }
}