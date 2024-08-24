import interfaces.ComportamentoGrunir
import interfaces.ComportamentoVoar

class PatoBorracha(
    private var comportamentoVoar: ComportamentoVoar,
    private var comportamentoGrunir: ComportamentoGrunir
) : Pato(comportamentoVoar, comportamentoGrunir) {
    fun infla() {
        println("Eu inflo")
    }
}