package com.example.dedmobile.models.character

import java.io.Serializable

class Character(
    var id: Int,
    var age: Int,
    var gender: String,
    var indexImage: Int,
    var nameCharacter: String ,
    var physicalDescription: String,
): Serializable