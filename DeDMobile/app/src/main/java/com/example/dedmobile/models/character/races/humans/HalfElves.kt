package com.example.dedmobile.models.character.races.humans

import com.example.dedmobile.models.character.Language
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.SpecialFeature
import com.example.dedmobile.models.character.attributes.ChoiceAttributes
import com.example.dedmobile.models.character.language.DefineLanguage
import com.example.dedmobile.models.character.races.IRace

class HalfElves : IRace {
    override fun defineRace(sheetDeD: SheetDeD): SheetDeD {
        sheetDeD.race.nameRace = "Meio Elfo"

        val choiceAttributes = ChoiceAttributes()
        sheetDeD.attributes[5].valueAt += 2
        sheetDeD.attributes = choiceAttributes.choiceAttributesSheet(sheetDeD.attributes)

        sheetDeD.displacement = 30

        val defineLanguage = DefineLanguage()
        val languagesAux = sheetDeD.languages.toMutableList()
        languagesAux.add(Language("Élfico"))
        languagesAux.add(Language(defineLanguage.defineLanguageRace()))
        sheetDeD.languages = languagesAux.toList()

        val specialFeaturesAux = sheetDeD.specialFeatures.toMutableList()
        specialFeaturesAux.add(SpecialFeature("Visão no escuro"))
        specialFeaturesAux.add(SpecialFeature("Resiliência Élfica"))
        specialFeaturesAux.add(SpecialFeature("Versatilidade em Perícias"))
        specialFeaturesAux.add(SpecialFeature("Proficiente em Perícias"))

        sheetDeD.specialFeatures = specialFeaturesAux

        return sheetDeD
    }
}