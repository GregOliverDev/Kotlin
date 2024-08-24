package animais

import org.example.som.Som
import org.example.voo.Voar

open class Pato(private var voo: Voar, private var som: Som) {
    fun voar(): String {
        return(this.voo.executarVoo())
    }

    fun som(): String {
        return (this.som.emitirSom())
    }
}