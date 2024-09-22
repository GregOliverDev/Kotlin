package org.example.models.character.races.dwarfs

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class HillDwarf : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Anão da Colina"

        sheetDeD.attributes[2].valueAt +=2
        sheetDeD.attributes[4].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Resiliência Anã"))
        specialFeaturesAux.add(SpecialFeature("Treinamento com Armaduras Anãs"))
        specialFeaturesAux.add(SpecialFeature("Armamento Anão"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}