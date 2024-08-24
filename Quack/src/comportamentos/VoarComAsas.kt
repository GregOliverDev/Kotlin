package comportamentos
import interfaces.ComportamentoVoar

class VoarComAsas : ComportamentoVoar {
    override fun voar() {
        println("Estou voando com asas!")
    }
}