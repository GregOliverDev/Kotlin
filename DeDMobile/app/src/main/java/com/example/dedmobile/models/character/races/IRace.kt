package com.example.dedmobile.models.character.races

import com.example.dedmobile.models.character.SheetDeD

interface IRace {
    fun defineRace(sheetDeD: SheetDeD): SheetDeD
}