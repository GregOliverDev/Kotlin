package models.character.classCharacters

import models.character.SheetDeD

interface IClassCharacter {
    fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD
}