package org.example.models.character.races.dwarfs

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class MountainDwarf : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Anão da Montanha"
        sheetDeD.attributes[0].valueAt +=2
        sheetDeD.attributes[2].valueAt +=2


        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Armamento Anão"))
        specialFeaturesAux.add(SpecialFeature("Treinamento com Armaduras Anãs"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}