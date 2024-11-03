package com.example.appcontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.appcontroller.models.User

class RelatActivity : ComponentActivity() {
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_relat)
        user = (intent.getSerializableExtra("CURRENT_USER") as? User)!!
    }
}