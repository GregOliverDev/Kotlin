package com.example.dedmobile.models.character.attributes

import com.example.dedmobile.models.character.attributes.IAttributes
import com.example.dedmobile.models.character.SheetDeD

class AttributesModel2 : IAttributes {
    override fun defineAttributesModel(sheetDeD: SheetDeD): SheetDeD {
        /*var controller: Int
        var currectNumbers: MutableList<Int>
        do {
            controller = 0
            val choiceAttributesNumbers = mutableListOf<Int>()
            var points = 27
            print("\nDigite o valor para Força: ")
            choiceAttributesNumbers.add(readln().toInt())
            print("Digite o valor para Destreza: ")
            choiceAttributesNumbers.add(readln().toInt())
            print("Digite o valor para Constituição: ")
            choiceAttributesNumbers.add(readln().toInt())
            print("Digite o valor para Inteligencia: ")
            choiceAttributesNumbers.add(readln().toInt())
            print("Digite o valor para Sabedoria: ")
            choiceAttributesNumbers.add(readln().toInt())
            print("Digite o valor para Carisma: ")
            choiceAttributesNumbers.add(readln().toInt())

            for (index in 0..5) {
                val chosenNumber = choiceAttributesNumbers[index]

                when (chosenNumber) {
                    15 -> points -= 9
                    14 -> points -= 7
                    13 -> points -= 5
                    12 -> points -= 4
                    11 -> points -= 3
                    10 -> points -= 2
                    9 -> points -= 1
                    8 -> points -= 0
                }

                if (chosenNumber < 8) {
                    println("\n  Regra Quebrada \nValor Digitado: $chosenNumber \nMenor que o permitido para ${sheetDeD.attributes[index].nameAttribute} Min(8) \nReiniciando")
                    controller = 1
                } else if (chosenNumber > 15) {
                    println("\n  Regra Quebrada \nValor Digitado: $chosenNumber \nMaior que o permitido para ${sheetDeD.attributes[index].nameAttribute} Max(15) \nReiniciando")
                    controller = 1
                }
            }
            if (points < 0) {
                println("\n  Regra Quebrada \nPontos Atuais: $points \nPontos Menores que o permitido \nReiniciando")
                controller = 1
            }
            currectNumbers = choiceAttributesNumbers
        } while (controller != 0)
        for (index in 0..5) {
            val currectChosenNumber = currectNumbers[index]
            sheetDeD.attributes[index].valueAt +=currectChosenNumber
        }
        println()*/
        return sheetDeD
    }
}