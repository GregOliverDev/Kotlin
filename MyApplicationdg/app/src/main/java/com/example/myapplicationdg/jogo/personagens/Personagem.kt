package com.example.myapplicationdg.jogo.personagens

import org.example.racas.Raca // ajuste conforme o caminho correto da sua classe Raca
import java.io.Serializable

class Personagem(var raca: Raca): Serializable {
    var id: Int = 0

    var forca: Int = 0
    var destreza: Int = 0
    var constituicao: Int = 0
    var inteligencia: Int = 0
    var sabedoria: Int = 0
    var carisma: Int = 0

    var nome = ""
    var descricao = ""
    var idade: Int = 0
    var genero = ""

    var vida: Int = 10

    // Função para atribuir atributos com controle de pontos
    private fun definirAtributo(nomeAtributo: String): Int {
        val custoPontos = mapOf(15 to 9, 14 to 7, 13 to 5, 12 to 4, 11 to 3, 10 to 2, 9 to 1, 8 to 0)
        var controller: Int
        var totalDePontos = 27
        var valorAtributo: Int

        do {
            print("Digite um valor entre 8 e 15 para $nomeAtributo: ")
            valorAtributo = readln().toInt()
            val custo = custoPontos[valorAtributo] ?: -1

            if (custo == -1 || totalDePontos - custo < 0) {
                println("Valor incorreto ou pontos insuficientes. Pontos atuais: $totalDePontos")
                controller = 1
            } else {
                totalDePontos -= custo
                controller = 0
            }
        } while (controller != 0)

        return valorAtributo
    }

    fun definirAtributos() {
        forca = definirAtributo("força")
        destreza = definirAtributo("destreza")
        constituicao = definirAtributo("constituição")
        inteligencia = definirAtributo("inteligência")
        sabedoria = definirAtributo("sabedoria")
        carisma = definirAtributo("carisma")
    }

    fun definirVida() {
        val bonusVida = listOf(
            -4, -4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10
        )
        vida += bonusVida[constituicao.coerceIn(1, 30) - 1]
    }

    fun mostrarAtributos() {
        println("\nVida: $vida")
        println("Força: $forca")
        println("Destreza: $destreza")
        println("Constituição: $constituicao")
        println("Inteligência: $inteligencia")
        println("Sabedoria: $sabedoria")
        println("Carisma: $carisma")
        println("=================================")
    }
}
