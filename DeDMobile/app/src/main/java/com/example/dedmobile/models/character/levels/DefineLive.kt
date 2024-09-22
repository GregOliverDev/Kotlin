package com.example.dedmobile.models.character.levels

import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.dice.D10
import com.example.dedmobile.models.dice.D12
import com.example.dedmobile.models.dice.D6
import com.example.dedmobile.models.dice.D8

class DefineLive {
    fun updateLive(sheetDeD: SheetDeD, valueChanged: Int) {
        if (valueChanged in 1..20) {
            val additionalHitPoints = when (sheetDeD.diceLive.type) {
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
