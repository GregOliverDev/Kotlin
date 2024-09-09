package org.example.models.character.races.humans

import models.character.Language
import models.character.SheetDeD
import org.example.models.character.races.IRace
import org.example.models.character.language.DefineLanguage

class Human : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD{
        sheetDeD.race.nameRace = "Humano"

        sheetDeD.displacement = 30

        val defineLanguage = DefineLanguage()
        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language(defineLanguage.defineLanguageRace()))

        sheetDeD.languages = languagesAux.toList()

        for(index in 0..5){
            sheetDeD.attributes[index].valueAt +=1
        }

        return sheetDeD
    }
}