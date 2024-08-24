import interfaces.ComportamentoGrunir
import interfaces.ComportamentoVoar

open class Pato(
     private var comportamentoVoar: ComportamentoVoar,
     private var comportamentoGrunir: ComportamentoGrunir
){

    fun voar() {
        comportamentoVoar.voar()
    }

    fun grunir() {
        comportamentoGrunir.grunir()
    }

}