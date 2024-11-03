package racas

import com.example.myapplicationdg.jogo.personagens.Personagem
import org.example.racas.Raca

class MeioOrc : Raca {
    val proficienciaForca = 2
    val proficienciaConstituicao = 1

    override fun aplicarProficiencias(personagem: Personagem): Personagem {
        personagem.forca += proficienciaForca
        personagem.constituicao += proficienciaConstituicao

        return personagem
    }
}
