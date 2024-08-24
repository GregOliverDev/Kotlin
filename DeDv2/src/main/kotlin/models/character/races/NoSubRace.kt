package org.example.models.character.races

import models.character.SheetDeD

class NoSubRace: IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Sem Sub-Raça"
        return sheetDeD
    }
}