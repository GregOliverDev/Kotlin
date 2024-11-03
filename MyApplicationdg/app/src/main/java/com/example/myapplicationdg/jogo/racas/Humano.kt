package org.example.racas

import com.example.myapplicationdg.jogo.personagens.Personagem

class Humano : Raca {
    val proficienciaForca = 1
    val proficienciaDestreza = 1
    val proficienciaConstituicao = 1
    val proficienciaInteligencia = 1
    val proficienciaSabedoria = 1
    val proficienciaCarisma = 1

    override fun aplicarProficiencias(personagem: Personagem): Personagem {
        personagem.forca += proficienciaForca
        personagem.destreza += proficienciaDestreza
        personagem.constituicao += proficienciaConstituicao
        personagem.inteligencia += proficienciaInteligencia
        personagem.sabedoria += proficienciaSabedoria
        personagem.carisma += proficienciaCarisma

        return personagem
    }
}
