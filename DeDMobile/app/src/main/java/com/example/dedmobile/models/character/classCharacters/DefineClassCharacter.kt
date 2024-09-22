package org.example.models.character.classCharacters

import models.character.SheetDeD
import models.character.classCharacters.IClassCharacter

class DefineClassCharacter(private var iClassCharacter: IClassCharacter, var sheetDeD: SheetDeD) {
    fun createClassCharacter(): SheetDeD {
        return iClassCharacter.defineClassCharacter(sheetDeD)
    }
}