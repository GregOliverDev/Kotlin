package animais

import org.example.som.SomFalse
import org.example.som.SomTrue
import org.example.voo.VoarComAsas
import org.example.voo.VoarComBalao
import kotlin.test.Test
import kotlin.test.assertEquals

class PatoTestes {

    private var patoBase = Pato(VoarComAsas(), SomTrue())
    private var patoDeBorracha = Pato(VoarComBalao(), SomFalse())

    @Test
    fun modoDeVooInicial() {
        assertEquals("Voando com asas", patoBase.voar())
        assertEquals("Voando com balão", patoDeBorracha.voar())
    }

    @Test
    fun modoDeSomInicial(){
        assertEquals("Som Verdadeiro", patoBase.som())
        assertEquals("Som Falso", patoDeBorracha.som())
    }
}