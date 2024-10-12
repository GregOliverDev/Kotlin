package com.example.dedmobile.models.character

import java.io.Serializable

class Mod(
    var nameMod: String,
    var valueMod: Int
) : Serializable{
    fun copy(): Mod {
        return Mod(nameMod, valueMod)
    }
}