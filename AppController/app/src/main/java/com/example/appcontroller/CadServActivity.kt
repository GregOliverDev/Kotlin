package com.example.appcontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.appcontroller.models.User

class CadServActivity : ComponentActivity() {
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cad_serv)
        user = (intent.getSerializableExtra("CURRENT_USER") as? User)!!

    }
}