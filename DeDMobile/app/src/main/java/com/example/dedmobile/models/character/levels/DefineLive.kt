package org.example.models.character.levels

import models.character.SheetDeD
import org.example.models.dice.D10
import org.example.models.dice.D12
import org.example.models.dice.D6
import org.example.models.dice.D8

class DefineLive {
    fun updateLive(sheetDeD: SheetDeD, valueChanged: Int) {
        if (valueChanged in 1..20) {
            val diceType = sheetDeD.diceLive.type
            val additionalHitPoints = when (diceType) {
                "1d6" -> D6().getRandomValue()
                "1d8" -> D8().getRandomValue()
                "1d10" -> D10().getRandomValue()
                "1d12" -> D12().getRandomValue()
                else -> 0
            }
            sheetDeD.hitPoints += additionalHitPoints
        }
    }
}
