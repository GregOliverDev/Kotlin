package racas

import com.example.myapplicationdg.jogo.personagens.Personagem
import org.example.racas.Raca

class Elfo : Raca {
    val proficienciaDestreza = 2

    override fun aplicarProficiencias(personagem: Personagem): Personagem {
        personagem.destreza += proficienciaDestreza

        return personagem
    }
}