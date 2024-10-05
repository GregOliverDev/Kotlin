package com.example.dedmobile.models.character.modifiers

import com.example.dedmobile.models.character.Attribute
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.Mod

class DefineMod {
    fun defineMods(): List<Mod> {
        val mods = mutableListOf(Mod("Modificador de Força", 0))
        mods.add(Mod("Modificador de Destreza", 0))
        mods.add(Mod("Modificador de Constituição", 0))
        mods.add(Mod("Modificador de Inteligência", 0))
        mods.add(Mod("Modificador de Sabedoria", 0))
        mods.add(Mod("Modificador de Carisma", 0))

        return mods
    }

    fun updateMod(mods: List<Mod>, attribute: Attribute, index: Int): List<Mod> {
        when (attribute.valueAttribute) {
            1 -> {
                mods[index].valueMod = -4
            }

            2 -> {
                mods[index].valueMod = -4
            }

            3 -> {
                mods[index].valueMod = -4
            }

            4 -> {
                mods[index].valueMod = -3
            }

            5 -> {
                mods[index].valueMod = -3
            }

            6 -> {
                mods[index].valueMod = -2
            }

            7 -> {
                mods[index].valueMod = -2
            }

            8 -> {
                mods[index].valueMod = -1
            }

            9 -> {
                mods[index].valueMod = -1
            }

            10 -> {
                mods[index].valueMod = 0
            }

            11 -> {
                mods[index].valueMod = 0
            }

            12 -> {
                mods[index].valueMod = 1
            }

            13 -> {
                mods[index].valueMod = 1
            }

            14 -> {
                mods[index].valueMod = 2
            }

            15 -> {
                mods[index].valueMod = 2
            }

            16 -> {
                mods[index].valueMod = 3
            }

            17 -> {
                mods[index].valueMod = 3
            }

            18 -> {
                mods[index].valueMod = 4
            }

            19 -> {
                mods[index].valueMod = 4
            }

            20 -> {
                mods[index].valueMod = 5
            }

            21 -> {
                mods[index].valueMod = 5
            }

            22 -> {
                mods[index].valueMod = 6
            }

            23 -> {
                mods[index].valueMod = 6
            }

            24 -> {
                mods[index].valueMod = 7
            }

            25 -> {
                mods[index].valueMod = 7
            }

            26 -> {
                mods[index].valueMod = 8
            }

            27 -> {
                mods[index].valueMod = 8
            }

            28 -> {
                mods[index].valueMod = 9
            }

            29 -> {
                mods[index].valueMod = 9
            }

            30 -> {
                mods[index].valueMod = 10
            }
        }
        return mods
    }
}