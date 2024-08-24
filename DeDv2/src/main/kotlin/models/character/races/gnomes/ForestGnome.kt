package org.example.models.character.races.gnomes

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class ForestGnome : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Gnomo da Floresta"

        sheetDeD.attributes[3].valueAt +=2
        sheetDeD.attributes[1].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Furtividade Natural"))
        specialFeaturesAux.add(SpecialFeature("Falar com Animais"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}