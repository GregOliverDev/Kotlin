package com.example.dedmobile.models.character.races.elves

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace
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