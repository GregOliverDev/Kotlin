package org.example.models.character.races.elves

import models.character.SheetDeD
import org.example.models.character.SpecialFeature
import org.example.models.character.races.IRace

class MoonElf : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.subRace.nameRace = "Elfo da Lua"

        sheetDeD.attributes[1].valueAt +=2
        sheetDeD.attributes[5].valueAt +=1

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Cantrip Mágica - Carisma"))
        specialFeaturesAux.add(SpecialFeature("Perícias Adicionais"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}