package com.example.dedmobile.models.character.attributes

class AttributesModel {
    fun defineAttributesModel(valueAttribute: Int): Int {
        var points: Int = 0
        when (valueAttribute) {
            15 -> points = 9
            14 -> points = 7
            13 -> points = 5
            12 -> points = 4
            11 -> points = 3
            10 -> points = 2
            9 -> points = 1
            8 -> points = 0
        }

        return points
    }
}