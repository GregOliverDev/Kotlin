package org.example.models.character.attributes

import models.character.SheetDeD
import org.example.models.dice.D6

class AttributesModel1 : IAttributes {
    override fun defineAttributesModel(sheetDeD: SheetDeD): SheetDeD {
        for (index in 0..5) {
            val listNubers = mutableListOf<Int>()
            for(numberRoll in 0..3){
                val d6 = D6()
                val valueD6: Int = d6.getRandomValue()
                listNubers.add(valueD6)
            }
            val minValue = listNubers.minOrNull()

            minValue?.let {
                listNubers.remove(it)
            }

            val sumListNumbers = listNubers.sum()

            sheetDeD.attributes[index].valueAt +=sumListNumbers
        }
        println()
        return sheetDeD
    }
}