package com.example.dedmobile.models.character.modifiers

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

    fun updateMod(sheetDeD: SheetDeD, nameAttribute: String) {
        for (index in 0..5) {
            if (sheetDeD.attributes[index].nameAttribute == nameAttribute) {
                when (sheetDeD.attributes[index].valueAttribute) {
                    1 -> {
                        sheetDeD.mods[index].valueMod = -4
                    }

                    2 -> {
                        sheetDeD.mods[index].valueMod = -4
                    }

                    3 -> {
                        sheetDeD.mods[index].valueMod = -4
                    }

                    4 -> {
                        sheetDeD.mods[index].valueMod = -3
                    }

                    5 -> {
                        sheetDeD.mods[index].valueMod = -3
                    }

                    6 -> {
                        sheetDeD.mods[index].valueMod = -2
                    }

                    7 -> {
                        sheetDeD.mods[index].valueMod = -2
                    }

                    8 -> {
                        sheetDeD.mods[index].valueMod = -1
                    }

                    9 -> {
                        sheetDeD.mods[index].valueMod = -1
                    }

                    10 -> {
                        sheetDeD.mods[index].valueMod = 0
                    }

                    11 -> {
                        sheetDeD.mods[index].valueMod = 0
                    }

                    12 -> {
                        sheetDeD.mods[index].valueMod = 1
                    }

                    13 -> {
                        sheetDeD.mods[index].valueMod = 1
                    }

                    14 -> {
                        sheetDeD.mods[index].valueMod = 2
                    }

                    15 -> {
                        sheetDeD.mods[index].valueMod = 2
                    }

                    16 -> {
                        sheetDeD.mods[index].valueMod = 3
                    }

                    17 -> {
                        sheetDeD.mods[index].valueMod = 3
                    }

                    18 -> {
                        sheetDeD.mods[index].valueMod = 4
                    }

                    19 -> {
                        sheetDeD.mods[index].valueMod = 4
                    }

                    20 -> {
                        sheetDeD.mods[index].valueMod = 5
                    }

                    21 -> {
                        sheetDeD.mods[index].valueMod = 5
                    }

                    22 -> {
                        sheetDeD.mods[index].valueMod = 6
                    }

                    23 -> {
                        sheetDeD.mods[index].valueMod = 6
                    }

                    24 -> {
                        sheetDeD.mods[index].valueMod = 7
                    }

                    25 -> {
                        sheetDeD.mods[index].valueMod = 7
                    }

                    26 -> {
                        sheetDeD.mods[index].valueMod = 8
                    }

                    27 -> {
                        sheetDeD.mods[index].valueMod = 8
                    }

                    28 -> {
                        sheetDeD.mods[index].valueMod = 9
                    }

                    29 -> {
                        sheetDeD.mods[index].valueMod = 9
                    }

                    30 -> {
                        sheetDeD.mods[index].valueMod = 10
                    }
                }
//                println(
//                    "Atributo ${sheetDeD.attributes[index].nameAttribute} alterado \n" +
//                            "Valor do atributo ${sheetDeD.attributes[index].valueAttribute}\n" +
//                            "Novo modificador ${sheetDeD.mods[index].valueMod}\n"
//                )
            }
        }
    }
}