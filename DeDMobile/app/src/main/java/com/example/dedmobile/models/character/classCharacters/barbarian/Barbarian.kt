package com.example.dedmobile.models.character.classCharacters.barbarian

import com.example.dedmobile.models.character.ClassCharacter
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.classCharacters.IClassCharacter
import com.example.dedmobile.models.dice.Dice

class Barbarian : IClassCharacter {
    override fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.diceLive = Dice("1d12")
        sheetDeD.amountDiceLive = 0
        sheetDeD.hitPoints = 12 + sheetDeD.mods[2].valueMod
        sheetDeD.currentHitPoints = 12 + sheetDeD.mods[2].valueMod
        sheetDeD.temporaryHitPoints = 0
        sheetDeD.classCharacter = ClassCharacter("Bárbaro", "No Path")

        return sheetDeD
    }
}