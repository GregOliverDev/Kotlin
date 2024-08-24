import comportamentos.*

fun main() {

    val pato = Pato(
        VoarComAsas(),
        GrunirNormal(),
    )
    val cacador = Cacador(GrunirFalso(), NaoVoar())

    println("Pato Normal")
    pato.voar()
    pato.grunir()

    println("\nCaçador")
    cacador.grunir()
    cacador.voar()
}
