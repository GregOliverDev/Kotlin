package org.example.models.character.classCharacters.wizard

import models.character.ClassCharacter
import models.character.SheetDeD
import models.character.classCharacters.IClassCharacter
import org.example.models.dice.Dice

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