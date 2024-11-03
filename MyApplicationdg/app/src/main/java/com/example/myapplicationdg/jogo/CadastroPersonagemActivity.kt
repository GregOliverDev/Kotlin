package com.example.myapplicationdg.jogo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationdg.R
import com.example.myapplicationdg.jogo.personagens.Personagem
import org.example.racas.Anao
import org.example.racas.Raca

class CadastroPersonagemActivity : AppCompatActivity() {

    private lateinit var nomeEditText: EditText
    private lateinit var descricaoEditText: EditText
    private lateinit var idadeEditText: EditText
    private lateinit var generoEditText: EditText
    private lateinit var avatarImageView: ImageView
    private lateinit var nextButton: Button
    private lateinit var personagem: Personagem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_personagem)

        // Inicializando os elementos do layout
        nomeEditText = findViewById(R.id.nomeEditText)
        descricaoEditText = findViewById(R.id.descricaoEditText)
        idadeEditText = findViewById(R.id.idadeEditText)
        generoEditText = findViewById(R.id.generoEditText)
        avatarImageView = findViewById(R.id.avatarImageView)
        nextButton = findViewById(R.id.nextButton)
        val raca: Raca = Anao()
        personagem = Personagem(raca)
        personagem.nome = nomeEditText.text.toString()
        personagem.idade = idadeEditText.text.toString().toIntOrNull() ?: 0
        personagem.genero = generoEditText.text.toString()
        personagem.descricao = descricaoEditText.text.toString()

        // Definir ação do botão "NEXT"
        nextButton.setOnClickListener {
            // Navega para a Activity Jogo
            val intent = Intent(this, JogoActivity::class.java)
            intent.putExtra("CURRENT_PERSONAGEM", personagem)
            startActivity(intent)
        }
    }
}
