package com.example.dedmobile.models.character.classCharacters.wizard

import com.example.dedmobile.models.character.ClassCharacter
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.classCharacters.IClassCharacter
import com.example.dedmobile.models.dice.Dice

class Wizard: IClassCharacter {
    override fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.diceLive = Dice("1d6")
        sheetDeD.amountDiceLive = 0
        sheetDeD.hitPoints = 6 + sheetDeD.mods[2].valueMod
        sheetDeD.currentHitPoints = 6 + sheetDeD.mods[2].valueMod
        sheetDeD.temporaryHitPoints = 0
        sheetDeD.classCharacter = ClassCharacter("Mago", "No Path")

        return sheetDeD
    }
}