package org.example.racas

import com.example.myapplicationdg.jogo.personagens.Personagem

// Implementação da interface Raca que aplica um bônus fixo de Constituição ao personagem
class Anao : Raca {
    val proficienciaConstituicao = 2

    // Recebe um objeto Personagem e o modifica aplicando as proficiências raciais específicas ao personagem
    override fun aplicarProficiencias(personagem: Personagem): Personagem {
        // Aumenta o valor do atributo constituicao do personagem pela proficiência de Constituição dos Anões
        personagem.constituicao += proficienciaConstituicao

        return personagem  // Retorna o objeto Personagem modificado
    }
}
