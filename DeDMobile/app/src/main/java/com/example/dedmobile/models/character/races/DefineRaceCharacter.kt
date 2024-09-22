package com.example.dedmobile.models.character.races

import com.example.dedmobile.models.character.SheetDeD

class DefineRaceCharacter(private var iRace: IRace, var sheetDeD: SheetDeD) {
    fun createRace(): SheetDeD {
        return iRace.defineRace(sheetDeD)
    }
}