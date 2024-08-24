package org.example.viewers

import models.player.Player

class PlayerMenu {
    fun createPlayerMenu(nextId: Int): Player {
        println("\n  Cadastro de Jogador")
        print("Nome: ")
        val namePlayer = readln()

        val player = Player(characterSheet = null, nextId, namePlayer)
        println("\nJogador ${player.namePlayer} Número $nextId \nCadastrado com Sucesso")
        return player
    }
}