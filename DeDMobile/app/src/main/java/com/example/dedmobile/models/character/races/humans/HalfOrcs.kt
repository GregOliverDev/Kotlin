package org.example.models.character.races.humans

import models.character.Language
import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class HalfOrcs : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Meio Orc"

        sheetDeD.attributes[0].valueAt += 2
        sheetDeD.attributes[2].valueAt += 1

        sheetDeD.displacement = 30

        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language("Orc"))

        sheetDeD.languages = languagesAux

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Fúria Orc"))
        specialFeaturesAux.add(SpecialFeature("Ataque Selvagem"))
        specialFeaturesAux.add(SpecialFeature("Resistência Implacável"))
        specialFeaturesAux.add(SpecialFeature("Visão no Escuro"))
        specialFeaturesAux.add(SpecialFeature("Ameaça Intimidante"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}