package org.example.models.character.races.elves

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class Drow : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Elfo das Trevas"

        sheetDeD.attributes[1].valueAt +=2
        sheetDeD.attributes[5].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Visão no Escuro Superior"))
        specialFeaturesAux.add(SpecialFeature("Furtividade Superior"))
        specialFeaturesAux.add(SpecialFeature("Habilidades Mágicas"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}