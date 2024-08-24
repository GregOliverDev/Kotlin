package org.example.viewers

import models.character.Campaign

class CampaignMenu {
    fun createCampaignMenu(campaigns: List<Campaign>): Campaign {
        var nameCampaign: String
        val descriptionCampaign: String
        val passwordCampaign: String

        do {
            println("\n  Cadastro de Campanha  ")
            print("Nome da Campanha: ")
            nameCampaign = readln()

            if (campaigns.any { it.nameCampaign == nameCampaign }) {
                println("Já existe uma campanha com esse nome. Tente outro nome.")
                continue
            }

            print("Descrição da Campanha: ")
            descriptionCampaign = readln()
            print("Senha da Campanha: ")
            passwordCampaign = readln()

            val campaign = Campaign(nameCampaign, descriptionCampaign, passwordCampaign)
            println("\nCampanha ${campaign.nameCampaign} cadastrada com sucesso")
            return campaign

        } while (true)
    }
}
