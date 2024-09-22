package com.example.dedmobile.models.character.classCharacters

import com.example.dedmobile.models.character.SheetDeD

interface IClassCharacter {
    fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD
}