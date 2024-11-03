package com.example.dedmobile.models.character

import java.io.Serializable

class Ability(
    var id: Int,
    var nameAbility: String,
    var attribute: Attribute
): Serializable