package org.example.models.character.attributes

import models.character.Attribute

class DefineAttributes {
    fun defineAttributes(): List<Attribute> {
        val attributes = mutableListOf(Attribute("Força", valueAttribute = 0))
        attributes.add(Attribute("Destreza", valueAttribute = 0))
        attributes.add(Attribute("Constituição", valueAttribute = 0))
        attributes.add(Attribute("Inteligência", valueAttribute = 0))
        attributes.add(Attribute("Sabedoria", valueAttribute = 0))
        attributes.add(Attribute("Carisma", valueAttribute = 0))

        return attributes
    }
}