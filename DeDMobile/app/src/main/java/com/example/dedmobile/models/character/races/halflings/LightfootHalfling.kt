package com.example.dedmobile.models.character.races.halflings

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

class LightfootHalfling : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Halfling Pés-Leves"

        sheetDeD.attributes[1].valueAt +=2
        sheetDeD.attributes[5].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Furtividade Natural"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}