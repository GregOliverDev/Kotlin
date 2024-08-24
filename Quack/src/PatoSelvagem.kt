import interfaces.ComportamentoGrunir
import interfaces.ComportamentoVoar

class PatoSelvagem(
    private var comportamentoVoar: ComportamentoVoar,
    private var comportamentoGrunir: ComportamentoGrunir
) : Pato(comportamentoVoar, comportamentoGrunir) {
    fun bicar() {
        println("Pato bicar")
    }
}