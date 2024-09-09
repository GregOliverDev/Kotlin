package org.example.models.character.races.halflings

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class StoutHalfling : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Halfling Robusto"

        sheetDeD.attributes[1].valueAt +=2
        sheetDeD.attributes[2].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Resiliência Halfling"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}