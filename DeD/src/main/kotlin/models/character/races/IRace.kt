package org.example.models.character.races

import models.character.SheetDeD

interface IRace {
    fun defineRace(sheetDeD: SheetDeD): SheetDeD
}