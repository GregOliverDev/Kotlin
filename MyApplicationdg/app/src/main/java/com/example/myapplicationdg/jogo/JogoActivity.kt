package com.example.myapplicationdg.jogo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationdg.R
import com.example.myapplicationdg.data.PersonagemController
import com.example.myapplicationdg.jogo.CadastroPersonagemActivity
import com.example.myapplicationdg.jogo.personagens.Personagem
import kotlin.math.floor

class JogoActivity : AppCompatActivity() {
    private lateinit var personagemController: PersonagemController
    private var pontos: Int = 27
    private lateinit var pontosTextView: TextView

    private lateinit var forcaValue: TextView
    private lateinit var destrezaValue: TextView
    private lateinit var constituicaoValue: TextView
    private lateinit var inteligenciaValue: TextView
    private lateinit var sabedoriaValue: TextView
    private lateinit var carismaValue: TextView

    private lateinit var forcaModifier: TextView
    private lateinit var destrezaModifier: TextView
    private lateinit var constituicaoModifier: TextView
    private lateinit var inteligenciaModifier: TextView
    private lateinit var sabedoriaModifier: TextView
    private lateinit var carismaModifier: TextView

    private lateinit var personagem: Personagem

    private lateinit var vidaTextView: TextView
    private var vida: Int = 10  // Vida inicial definida como 10, sem modificadores

    override fun onCreate(savedInstanceState: Bundle?) {
        personagemController = PersonagemController(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        personagem = (intent.getSerializableExtra("CURRENT_PERSONAGEM")as Personagem)!!

        pontosTextView = findViewById(R.id.pontosTextView)

        // Inicializando valores dos atributos
        forcaValue = findViewById(R.id.forcaValue)
        destrezaValue = findViewById(R.id.destrezaValue)
        constituicaoValue = findViewById(R.id.constituicaoValue)
        inteligenciaValue = findViewById(R.id.inteligenciaValue)
        sabedoriaValue = findViewById(R.id.sabedoriaValue)
        carismaValue = findViewById(R.id.carismaValue)

        // Inicializando os TextViews dos modificadores
        forcaModifier = findViewById(R.id.forcaModifier)
        destrezaModifier = findViewById(R.id.destrezaModifier)
        constituicaoModifier = findViewById(R.id.constituicaoModifier)
        inteligenciaModifier = findViewById(R.id.inteligenciaModifier)
        sabedoriaModifier = findViewById(R.id.sabedoriaModifier)
        carismaModifier = findViewById(R.id.carismaModifier)

        // Inicializando o TextView para exibir a vida
        vidaTextView = findViewById(R.id.vidaTextView)
        vidaTextView.text = "Vida: $vida"  // Exibe a vida inicial como 10

        // Configurar botões de incremento e decremento para todos os atributos
        setupIncrementDecrementButtons()

        // Botão para voltar para a tela de cadastro de personagem
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, CadastroPersonagemActivity::class.java)
            startActivity(intent)
        }

        // Configurar lógica para o botão "Next"
        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            // Calcular modificadores e exibir
            calcularModificadores()
            atualizarVida()  // Atualiza a vida ao clicar em "Next"
            personagem.forca = forcaValue.toString().toIntOrNull() ?: 0
            personagem.destreza = destrezaValue.toString().toIntOrNull() ?: 0
            personagem.constituicao = constituicaoValue.toString().toIntOrNull() ?: 0
            personagem.inteligencia = inteligenciaModifier.toString().toIntOrNull() ?: 0
            personagem.sabedoria = sabedoriaModifier.toString().toIntOrNull() ?: 0
            personagem.carisma = carismaModifier.toString().toIntOrNull() ?: 0

            val result = personagemController.insertPersonagem(personagem, "Anão")

            if (result){
                val toast = Toast.makeText(this,"Personagem registrado com exito", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                val toast = Toast.makeText(this,"Personagem não registrado", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    private fun setupIncrementDecrementButtons() {
        configureButtonPair(R.id.incrementForcaButton, R.id.decrementForcaButton, forcaValue)
        configureButtonPair(R.id.incrementDestrezaButton, R.id.decrementDestrezaButton, destrezaValue)
        configureButtonPair(R.id.incrementConstituicaoButton, R.id.decrementConstituicaoButton, constituicaoValue, isConstituicao = true)
        configureButtonPair(R.id.incrementInteligenciaButton, R.id.decrementInteligenciaButton, inteligenciaValue)
        configureButtonPair(R.id.incrementSabedoriaButton, R.id.decrementSabedoriaButton, sabedoriaValue)
        configureButtonPair(R.id.incrementCarismaButton, R.id.decrementCarismaButton, carismaValue)
    }

    private fun configureButtonPair(incrementButtonId: Int, decrementButtonId: Int, attributeValueView: TextView, isConstituicao: Boolean = false) {
        val incrementButton: Button = findViewById(incrementButtonId)
        val decrementButton: Button = findViewById(decrementButtonId)

        incrementButton.setOnClickListener {
            alterarAtributo(attributeValueView, 1, isConstituicao)
        }

        decrementButton.setOnClickListener {
            alterarAtributo(attributeValueView, -1, isConstituicao)
        }
    }

    private fun alterarAtributo(atributoTextView: TextView, valor: Int, isConstituicao: Boolean = false) {
        val valorAtual = atributoTextView.text.toString().toInt()
        val novoValor = valorAtual + valor

        if (novoValor in 8..15 && pontos - valor >= 0) {
            atributoTextView.text = novoValor.toString()
            pontos -= valor
            pontosTextView.text = "Pontos: $pontos"

            // Atualizar vida se o atributo alterado for Constituição
            if (isConstituicao) {
                atualizarVida()
            }

        } else {
            Toast.makeText(this, "Pontos insuficientes ou limite de atributo", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calcularModificadores() {
        // Fórmula para calcular modificador: (atributo - 10) / 2
        fun calcularModificador(atributo: Int): Int {
            return floor((atributo - 10) / 2.0).toInt()
        }

        // Obter os valores atuais dos atributos
        val forca = forcaValue.text.toString().toInt()
        val destreza = destrezaValue.text.toString().toInt()
        val constituicao = constituicaoValue.text.toString().toInt()
        val inteligencia = inteligenciaValue.text.toString().toInt()
        val sabedoria = sabedoriaValue.text.toString().toInt()
        val carisma = carismaValue.text.toString().toInt()

        // Calcular modificadores
        val forcaMod = calcularModificador(forca)
        val destrezaMod = calcularModificador(destreza)
        val constituicaoMod = calcularModificador(constituicao)
        val inteligenciaMod = calcularModificador(inteligencia)
        val sabedoriaMod = calcularModificador(sabedoria)
        val carismaMod = calcularModificador(carisma)

        // Atualizar os valores finais com modificadores (atributo base + modificador)
        forcaModifier.text = (forca - forcaMod).toString()
        destrezaModifier.text = (destreza - destrezaMod).toString()
        constituicaoModifier.text = (constituicao - constituicaoMod).toString()
        inteligenciaModifier.text = (inteligencia - inteligenciaMod).toString()
        sabedoriaModifier.text = (sabedoria - sabedoriaMod).toString()
        carismaModifier.text = (carisma - carismaMod).toString()
    }


    // Função para atualizar a vida com base na Constituição
    private fun atualizarVida() {
        val constituicao = constituicaoValue.text.toString().toInt()
        val bonusVida = listOf(
            -4, -4, -4, // Para constituição de 1 a 3
            -3, -3, // Para constituição de 4 a 5
            -2, -2, // Para constituição de 6 a 7
            -1, -1, // Para constituição de 8 a 9
            0, 0,   // Para constituição de 10 a 11
            1, 1,   // Para constituição de 12 a 13
            2, 2,   // Para constituição de 14 a 15
            3, 3,   // Para constituição de 16 a 17
            4, 4,   // Para constituição de 18 a 19
            5, 5,   // Para constituição de 20 a 21
            6, 6,   // Para constituição de 22 a 23
            7, 7,   // Para constituição de 24 a 25
            8, 8,   // Para constituição de 26 a 27
            9, 9,   // Para constituição de 28 a 29
            10      // Para constituição de 30
        )

        // Verifica o bônus com base na Constituição
        val bonus = bonusVida[constituicao.coerceIn(1, 30) - 1]

        // A base da vida é sempre 10. O bônus só será aplicado para valores diferentes de zero.
        vida = 10 + if (bonus >= 0) bonus else 0
        vidaTextView.text = "Vida: $vida"


    }
}
