package com.example.dedmobile.models.character.classCharacters.monk

import com.example.dedmobile.models.character.ClassCharacter
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.classCharacters.IClassCharacter
import com.example.dedmobile.models.dice.Dice

class Monk : IClassCharacter {
    override fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.diceLive = Dice("1d8")
        sheetDeD.amountDiceLive = 0
        sheetDeD.hitPoints = 8 + sheetDeD.mods[2].valueMod
        sheetDeD.currentHitPoints = 8 + sheetDeD.mods[2].valueMod
        sheetDeD.temporaryHitPoints = 0
        sheetDeD.classCharacter = ClassCharacter("Monge", "No Path")

        return sheetDeD
    }
}