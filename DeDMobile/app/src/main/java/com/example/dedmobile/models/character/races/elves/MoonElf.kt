package com.example.dedmobile.models.character.races.elves

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

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