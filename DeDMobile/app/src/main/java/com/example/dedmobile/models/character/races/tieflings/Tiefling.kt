package com.example.dedmobile.models.character.races.tieflings

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

class Tiefling : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Tiefling"

        sheetDeD.attributes[3].valueAt +=1
        sheetDeD.attributes[5].valueAt +=2

        sheetDeD.displacement = 30

        val language = Language("Infernal")
        val languagesAux = mutableListOf(language)

        sheetDeD.languages = languagesAux

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Visão no escuro"))
        specialFeaturesAux.add(SpecialFeature("Resistência Infernal"))
        specialFeaturesAux.add(SpecialFeature("Magia Infernal"))
        specialFeaturesAux.add(SpecialFeature("Poderes Infernais"))
        specialFeaturesAux.add(SpecialFeature("Repreensão Infernal"))
        specialFeaturesAux.add(SpecialFeature("Escuridão"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}