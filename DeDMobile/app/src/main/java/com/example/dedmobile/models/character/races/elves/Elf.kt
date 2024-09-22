package org.example.models.character.races.elves

import models.character.Language
import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class Elf : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Elfo"

        sheetDeD.displacement = 30

        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language("Élfico"))

        sheetDeD.languages = languagesAux.toList()

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Visão no escuro"))
        specialFeaturesAux.add(SpecialFeature("Resistência a Encantamentos"))
        specialFeaturesAux.add(SpecialFeature("Transe"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}