package org.example.models.character.classCharacters.druid

import models.character.ClassCharacter
import models.character.SheetDeD
import models.character.classCharacters.IClassCharacter
import org.example.models.dice.Dice

class Druid : IClassCharacter {
    override fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.diceLive = Dice("1d8")
        sheetDeD.amountDiceLive = 0
        sheetDeD.hitPoints = 8 + sheetDeD.mods[2].valueMod
        sheetDeD.currentHitPoints = 8 + sheetDeD.mods[2].valueMod
        sheetDeD.temporaryHitPoints = 0
        sheetDeD.classCharacter = ClassCharacter("Druida", "No Path")

        return sheetDeD
    }
}