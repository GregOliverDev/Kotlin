package org.example.models.character.races.gnomes

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class RockGnome : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Gnomo das Rochas"

        sheetDeD.attributes[3].valueAt +=2
        sheetDeD.attributes[2].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Conhecimento de Mecânica"))
        specialFeaturesAux.add(SpecialFeature("Proficiência em Ferramentas de Artesão"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}