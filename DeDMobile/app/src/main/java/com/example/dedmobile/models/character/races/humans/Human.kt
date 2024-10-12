package com.example.dedmobile.models.character.races.humans

import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.races.IRace

class Human : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Humano"

        sheetDeD.displacement = 30

        for(index in 0..5){
            sheetDeD.attributes[index].valueAt +=1
        }

        return sheetDeD
    }
}