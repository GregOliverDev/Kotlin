package com.example.dedmobile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.dedmobile.R
import com.example.dedmobile.fragment.CharacterFragment1

class CharacterActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        val loginName = intent.getStringExtra("LOGIN_NAME")
        val myButton: Button = findViewById(R.id.bt_next)
        myButton.text = loginName

        fragmentManager = supportFragmentManager

        if (savedInstanceState == null) {
            val fragment = CharacterFragment1()
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }
}
