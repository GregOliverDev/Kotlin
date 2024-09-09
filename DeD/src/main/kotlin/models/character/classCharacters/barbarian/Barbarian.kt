package org.example.models.character.classCharacters.barbarian

import models.character.ClassCharacter
import models.character.SheetDeD
import models.character.classCharacters.IClassCharacter
import org.example.models.dice.Dice

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