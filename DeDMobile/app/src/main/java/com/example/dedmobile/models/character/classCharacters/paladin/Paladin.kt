package com.example.dedmobile.models.character.classCharacters.paladin

import com.example.dedmobile.models.character.ClassCharacter
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.classCharacters.IClassCharacter
import com.example.dedmobile.models.dice.Dice

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