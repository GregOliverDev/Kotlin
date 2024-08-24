package comportamentos

import interfaces.ComportamentoGrunir

class GrunirNormal : ComportamentoGrunir {
    override fun grunir() {
        println("Grunhindo normalmente!")
    }
}