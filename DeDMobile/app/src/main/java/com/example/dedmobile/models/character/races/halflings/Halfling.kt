package com.example.dedmobile.models.character.races.halflings

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

class Halfling : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Halfling"

        sheetDeD.displacement = 25

        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language("Halfling"))

        sheetDeD.languages = languagesAux.toList()

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Sorte"))
        specialFeaturesAux.add(SpecialFeature("Bravura"))
        specialFeaturesAux.add(SpecialFeature("Ágil e Discreto"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}