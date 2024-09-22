package com.example.dedmobile.models.character.classCharacters

import com.example.dedmobile.models.character.SheetDeD

class DefineClassCharacter(private var iClassCharacter: IClassCharacter, var sheetDeD: SheetDeD) {
    fun createClassCharacter(): SheetDeD {
        return iClassCharacter.defineClassCharacter(sheetDeD)
    }
}