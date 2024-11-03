package com.example.appcontroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.appcontroller.data.UserSave
import com.example.appcontroller.models.User
import com.example.appcontroller.shared.ToastStyle

class LoginActivity : ComponentActivity() {
    private lateinit var user: User
    private lateinit var userSave: UserSave
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userSave = UserSave(this)

        val nameUser: TextView = findViewById(R.id.user)
        val passUser: TextView = findViewById(R.id.pass)

        val findFirst = userSave.getUser("1", "1")
        if(findFirst == null){
            var userFirst = userSave.insertUser("1", "1")
        }

        val btEnter: Button = findViewById(R.id.bt_enter)
        btEnter.setOnClickListener{
            val nameUserText: String = nameUser.text.toString()
            val passUserText: String = passUser.text.toString()

            val findUser = userSave.getUser(nameUserText, passUserText)
            if(findUser == null){
                val toastStyle = ToastStyle(this)
                toastStyle.showCustomToast("Usuário não encontrado", 5000)
            }else{
                user = findUser
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("CURRENT_USER", user)
                startActivity(intent)
            }
        }
    }
}
