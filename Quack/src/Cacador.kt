import interfaces.ComportamentoGrunir
import interfaces.ComportamentoVoar

open class Cacador(private var comportamentoGrunir: ComportamentoGrunir, private var comportamentoVoar: ComportamentoVoar) {

    fun voar() {
        comportamentoVoar.voar()
    }

    fun grunir() {
        this.comportamentoGrunir.grunir()
    }

    fun atirar(){
        println("Eu atiro");
    }
}