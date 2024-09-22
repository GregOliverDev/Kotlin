package com.example.dedmobile.models.character.races.gnomes

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.races.IRace

class Gnome : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Gnomo"

        sheetDeD.displacement = 25

        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language("Gnômico"))

        sheetDeD.languages = languagesAux.toList()

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Visão no Escuro"))
        specialFeaturesAux.add(SpecialFeature("Astúcia Gnômica"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}