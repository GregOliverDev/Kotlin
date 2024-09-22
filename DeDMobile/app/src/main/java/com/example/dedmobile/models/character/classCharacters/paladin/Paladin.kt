package org.example.models.character.classCharacters.paladin

import models.character.ClassCharacter
import models.character.SheetDeD
import models.character.classCharacters.IClassCharacter
import org.example.models.dice.Dice

class Paladin : IClassCharacter {
    override fun defineClassCharacter(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.diceLive = Dice("1d10")
        sheetDeD.amountDiceLive = 0
        sheetDeD.hitPoints = 10 + sheetDeD.mods[2].valueMod
        sheetDeD.currentHitPoints = 10 + sheetDeD.mods[2].valueMod
        sheetDeD.temporaryHitPoints = 0
        sheetDeD.classCharacter = ClassCharacter("Paladino", "No Path")

        return sheetDeD
    }
}