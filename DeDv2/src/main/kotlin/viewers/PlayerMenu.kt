package org.example.viewers

import models.player.Player

class PlayerMenu(private val nameProvider: () -> String) {

    fun createPlayerMenu(nextId: Int): Player {
        println("\n  Cadastro de Jogador")
        val namePlayer = nameProvider()

        val player = Player(characterSheet = null, nextId, namePlayer)
        println("\nJogador ${player.namePlayer} Número $nextId \nCadastrado com Sucesso")
        return player
    }
}
