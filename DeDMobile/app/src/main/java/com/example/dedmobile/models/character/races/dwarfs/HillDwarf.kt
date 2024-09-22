package com.example.dedmobile.models.character.races.dwarfs

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

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