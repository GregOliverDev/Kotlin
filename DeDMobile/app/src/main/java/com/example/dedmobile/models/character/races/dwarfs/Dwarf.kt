package com.example.dedmobile.models.character.races.dwarfs

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

class Dwarf : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Anão"

        sheetDeD.displacement = 25

        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language("Anão"))

        sheetDeD.languages = languagesAux.toList()

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Visão no escuro"))
        specialFeaturesAux.add(SpecialFeature("Resistência Anã"))
        specialFeaturesAux.add(SpecialFeature("Conhecimento de Rochas"))
        specialFeaturesAux.add(SpecialFeature("Proficiente com Ferramentas"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}