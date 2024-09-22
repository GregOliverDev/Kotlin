package org.example.models.character.abilities

import models.character.Ability
import models.character.Attribute
import org.example.models.character.attributes.DefineAttributes

class DefineAbilities {
    fun defineAbilities(): List<Ability> {
        val attributes: List<Attribute> = DefineAttributes().defineAttributes().toList()

        // Strength (Índice 0)
        val abilities = mutableListOf(Ability("Atletismo", attributes[0]))

        // Dexterity (Índice 1)
        abilities.add(Ability("Acrobacia", attributes[1]))
        abilities.add(Ability("Furtividade", attributes[1]))
        abilities.add(Ability("Prestidigitação", attributes[1]))

        // Constitution (Índice 2) — Não tem habilidades associadas diretamente

        // Intelligence (Índice 3)
        abilities.add(Ability("Arcanismo", attributes[3]))
        abilities.add(Ability("História", attributes[3]))
        abilities.add(Ability("Investigação", attributes[3]))
        abilities.add(Ability("Natureza", attributes[3]))
        abilities.add(Ability("Religião", attributes[3]))

        // Wisdom (Índice 4)
        abilities.add(Ability("Intuição", attributes[4]))
        abilities.add(Ability("Medicina", attributes[4]))
        abilities.add(Ability("Percepção", attributes[4]))
        abilities.add(Ability("Sobrevivência", attributes[4]))
        abilities.add(Ability("Trato com Animais", attributes[4]))

        // Charisma (Índice 5)
        abilities.add(Ability("Enganação", attributes[5]))
        abilities.add(Ability("Intimidação", attributes[5]))
        abilities.add(Ability("Performance", attributes[5]))
        abilities.add(Ability("Persuasão", attributes[5]))

        return abilities
    }
}
