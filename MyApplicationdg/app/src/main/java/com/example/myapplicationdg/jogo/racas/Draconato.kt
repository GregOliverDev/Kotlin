package racas

import com.example.myapplicationdg.jogo.personagens.Personagem
import org.example.racas.Raca

class Draconato : Raca {
    val proficienciaForca = 2
    val proficienciaCarisma = 1

    override fun aplicarProficiencias(personagem: Personagem): Personagem {
        personagem.forca += proficienciaForca
        personagem.carisma += proficienciaCarisma

        return personagem
    }
}
