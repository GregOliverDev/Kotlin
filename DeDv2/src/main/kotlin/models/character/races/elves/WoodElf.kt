package org.example.models.character.races.elves

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class WoodElf : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Elfo da Floresta"

        sheetDeD.attributes[1].valueAt +=2
        sheetDeD.attributes[4].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Perícias Adicionais"))
        specialFeaturesAux.add(SpecialFeature("Habilidades de Furtividade"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}