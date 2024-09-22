package com.example.dedmobile.models.character.races.humans

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.language.DefineLanguage
import com.example.dedmobile.models.character.races.IRace

class Human : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
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