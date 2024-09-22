package com.example.dedmobile.models.character.races

import com.example.dedmobile.models.character.SheetDeD

class NoSubRace: IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Sem Sub-Raça"
        return sheetDeD
    }
}