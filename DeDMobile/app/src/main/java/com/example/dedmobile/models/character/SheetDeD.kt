package com.example.dedmobile.models.character

import com.example.dedmobile.models.dice.Dice
import java.io.Serializable

class SheetDeD(
    var abilities: List<Ability>,
    var attributes: List<Attribute>,
    var amountDiceLive: Int,
    var race: Race,
    var characterSheet: Character,
    var classCharacter: ClassCharacter,
    var currentHitPoints: Int,
    var diceLive: Dice,
    var displacement: Int,
    var hitPoints: Int,
    var id: Int,
    var languages: List<Language>,
    var level: Level,
    var mods: List<Mod>,
    var subRace: Race,
    var specialFeatures: List<SpecialFeature>,
    var temporaryHitPoints: Int,
): Serializable
