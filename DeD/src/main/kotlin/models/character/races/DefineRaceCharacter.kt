package org.example.models.character.races

import models.character.SheetDeD

class DefineRaceCharacter(private var iRace: IRace, var sheetDeD: SheetDeD) {
    fun createRace(): SheetDeD {
        return iRace.defineRace(sheetDeD)
    }
}