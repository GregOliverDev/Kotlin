package com.example.myapplicationdg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationdg.jogo.CadastroPersonagemActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referência ao botão "Iniciar Jogo"
        val startButton: Button = findViewById(R.id.start_button)

        // Definindo o comportamento do botão para iniciar o cadastro de personagem
        startButton.setOnClickListener {
            // Exibe uma mensagem para confirmar a ação
            Toast.makeText(this, "Botão Iniciar Jogo clicado", Toast.LENGTH_SHORT).show()

            // Vai para a tela de cadastro do personagem (CadastroPersonagemActivity)
            val intent = Intent(this@MainActivity, CadastroPersonagemActivity::class.java)
            startActivity(intent)
        }
    }
}
