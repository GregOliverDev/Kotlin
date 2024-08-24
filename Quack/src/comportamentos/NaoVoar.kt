package comportamentos

import interfaces.ComportamentoVoar

class NaoVoar : ComportamentoVoar {
    override fun voar() {
        println("Eu não posso voar.")
    }
}