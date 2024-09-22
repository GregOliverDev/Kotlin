package com.example.dedmobile.models.character

import com.example.dedmobile.models.character.Mod
import com.example.dedmobile.models.character.abilities.DefineAbilities
import com.example.dedmobile.models.character.attributes.DefineAttributes
import com.example.dedmobile.models.character.modifiers.DefineMod
import com.example.dedmobile.models.dice.Dice

class SheetDeD(
    var abilities: List<Ability> = DefineAbilities().defineAbilities().toList(),
    var amountDiceLive: Int,
    var attributes: List<Attribute> = DefineAttributes().defineAttributes().toList(),
    var race: Race,
    var campaign: Campaign,
    var characterSheet: Character,
    var classCharacter: ClassCharacter,
    var currentHitPoints: Int,
    var diceLive: Dice,
    var displacement: Int,
    var hitPoints: Int,
    var languages: List<Language> = listOf(Language("Comun")),
    var level: Level,
    var mods: List<Mod> = DefineMod().defineMods(),
    //var proficiencies: List<Proficiency>,
    //var resistances: List<Resistance>,
    var subRace: Race,
    var specialFeatures: List<SpecialFeature>,
    var temporaryHitPoints: Int,
    var xp: Int
)
