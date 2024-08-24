package org.example

import models.character.Campaign
import models.player.Player
import org.example.viewers.CampaignMenu
import org.example.viewers.PlayerMenu
import org.example.viewers.SheetMenu

fun main() {
    println("Minha Segunda versão do D&D")
    var controller: Int
    val players: MutableList<Player> = mutableListOf()
    val campaigns: MutableList<Campaign> = mutableListOf()

    do {
        println("\n  Menu Inicial  ")
        println("1 - Cadastro Jogador")
        println("2 - Cadastro Campanha")
        println("3 - Cadastro Personagem")
        println("4 - Fechar Sistema")

        print("\nEscolha a opção: ")
        controller = readln().toInt()

        when (controller) {
            1 -> {
                val playerMenu = PlayerMenu(
                    nameProvider = {
                        print("Digite o nome do jogador: ")
                        readln()
                    }
                )
                players.add(playerMenu.createPlayerMenu(players.size + 1))
            }

            2 -> {
                val campaignMenu = CampaignMenu()
                campaigns.add(campaignMenu.createCampaignMenu(campaigns))
            }

            3 -> {
                val sheetMenu = SheetMenu()
                print("Digite o número do Jogador: ")
                val numberPlayer = readln().toInt()
                print("Digite o nome da campanha: ")
                val nameCampaign = readln()


                val player = players.find { it.id == numberPlayer }
                if (player != null) {

                    val campaign = campaigns.find { it.nameCampaign == nameCampaign }
                    if (campaign != null) {
                        val sheetDeD = sheetMenu.createSheetMenu(campaign)
                        val sheetsDeD = player.characterSheet?.toMutableList() ?: mutableListOf()

                        sheetsDeD.add(sheetDeD)

                        player.characterSheet = sheetsDeD
                    } else {
                        println("Campanha não encontrada.")
                    }
                } else {
                    println("Jogador não encontrado.")
                }
            }

            4 -> {
                controller = 4
            }

            else -> {
                println("Opção inválida")
            }
        }

    } while (controller != 4)
}