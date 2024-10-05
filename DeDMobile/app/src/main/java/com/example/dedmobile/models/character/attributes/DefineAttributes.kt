package com.example.dedmobile.models.character.attributes

import com.example.dedmobile.models.character.Attribute

class DefineAttributes {
    fun defineAttributes(): List<Attribute> {
        val attributes = mutableListOf(Attribute("Força", valueAttribute = 8))
        attributes.add(Attribute("Destreza", valueAttribute = 8))
        attributes.add(Attribute("Constituição", valueAttribute = 8))
        attributes.add(Attribute("Inteligência", valueAttribute = 8))
        attributes.add(Attribute("Sabedoria", valueAttribute = 8))
        attributes.add(Attribute("Carisma", valueAttribute = 8))

        attributes[0].valueAt = 8
        attributes[1].valueAt = 8
        attributes[2].valueAt = 8
        attributes[3].valueAt = 8
        attributes[4].valueAt = 8
        attributes[5].valueAt = 8

        return attributes
    }
}