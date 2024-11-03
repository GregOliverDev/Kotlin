package racas

import com.example.myapplicationdg.jogo.personagens.Personagem
import org.example.racas.Raca

class MeioElfo : Raca {
    val proficienciaInteligencia = 1
    val proficienciaCarisma = 2


    override fun aplicarProficiencias(personagem: Personagem): Personagem {
        personagem.inteligencia += proficienciaInteligencia
        personagem.carisma += proficienciaCarisma

        return personagem
    }
}