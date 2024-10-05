      
        val race = Race("New Instence Race")
        var iRace: IRace = Dwarf()
        val subRace = Race("New Instence Sub Race")
        var iSubRace: IRace = HillDwarf()
        val specialFeatures: List<SpecialFeature> = listOf()
        val classCharacter = ClassCharacter("New Instence Class", "No Path")
        var iClassCharacter: IClassCharacter = Barbarian()
        val dice = Dice("")
        var sheetDeD = SheetDeD(
            DefineAbilities().defineAbilities().toList(),
            0,
            DefineAttributes().defineAttributes().toList(),
            race,
            campaign,
            character,
            classCharacter,
            0,
            dice,
            0,
            0,
            listOf(Language("Comun")),
            level,
            DefineMod().defineMods(),
            subRace,
            specialFeatures,
            0,
            0
        )


        

        Topic.subscribe("alterLevel") { valueChanged ->
            val defineLive = DefineLive()
            defineLive.updateLive(sheetDeD, valueChanged.toString().toInt())
        }

        var controller: Int
        do {
            println("\n  Menu Atributo")
            println("1 - Método Aleatorio")
            println("2 - Método por Pontos")
            println("3 - Descrição dos métodos")

            print("\nEscolha a opção: ")
            controller = readln().toInt()

            when (controller) {
                1 -> {
                    iAttributes = AttributesModel1()
                    controller = 0
                }

                2 -> {
                    iAttributes = AttributesModel2()
                    controller = 0
                }

                3 -> {
                    println("\n   Método Aleatorio\nGera 4d6 subtrai o menor e\nadiciona a soma ao atributo")
                    println(
                        "\n   Método por Pontos\nJogador pode escolher qual valor sera atribuido\n" +
                                "a cada atributotendo um total de 27 pontos para \ndistribuir Atributo sendo no max(15) e min(8)"
                    )
                }
            }

        } while (controller != 0)

        val defineAttributesModel = DefineAttributesModel(iAttributes, sheetDeD)
        sheetDeD = defineAttributesModel.createAttributesModel()

        var raceController: Int
        do {
            println("\n  Menu Raça")
            println("1 - Anão")
            println("2 - Elfo")
            println("3 - Gnomo")
            println("4 - Halfling")
            println("5 - Humano")
            println("6 - Meio-Elfo")
            println("7 - Meio-Orc")
            println("8 - Tiefling")

            print("\nEscolha sua Raça: ")
            raceController = readln().toInt()

            when (raceController) {
                1 -> {
                    iRace = Dwarf()
                    raceController = 0
                }

                2 -> {
                    iRace = Elf()
                    raceController = 0
                }

                3 -> {
                    iRace = Gnome()
                    raceController = 0
                }

                4 -> {
                    iRace = Halfling()
                    raceController = 0
                }

                5 -> {
                    iRace = Human()
                    raceController = 0
                }

                6 -> {
                    iRace = HalfElves()
                    raceController = 0
                }

                7 -> {
                    iRace = HalfOrcs()
                    raceController = 0
                }

                8 -> {
                    iRace = Tiefling()
                    raceController = 0
                }

                else -> {
                    println("Opção inválida")
                }
            }

        } while (raceController != 0)

        var subRaceController: Int
        when (iRace) {
            is Dwarf -> {
                do {
                    println("\n  Menu Sub-Raça de Anão")
                    println("1 - Anão da Colina")
                    println("2 - Anão das Montanhas")
                    println("3 - Sem Sub-Raça")

                    print("\nEscolha sua Sub-Raça: ")
                    subRaceController = readln().toInt()

                    when (subRaceController) {
                        1 -> {
                            iSubRace = HillDwarf()
                            subRaceController = 0
                        }

                        2 -> {
                            iSubRace = MountainDwarf()
                            subRaceController = 0
                        }

                        3 -> {
                            iSubRace = NoSubRace()
                            subRaceController = 0
                        }

                        else -> {
                            println("Opção inválida")
                        }
                    }

                } while (subRaceController != 0)
            }

            is Elf -> {
                do {
                    println("\n  Menu Sub-Raça de Elfo")

                    println("1 - Elfo das Trevas")
                    println("2 - Alto Elfo")
                    println("3 - Elfo da Lua")
                    println("4 - Elfo da Floresta")
                    println("5 - Sem Sub-Raça")

                    print("\nEscolha sua Sub-Raça: ")
                    subRaceController = readln().toInt()

                    when (subRaceController) {
                        1 -> {
                            iSubRace = Drow()
                            subRaceController = 0
                        }

                        2 -> {
                            iSubRace = HighElf()
                            subRaceController = 0
                        }

                        3 -> {
                            iSubRace = MoonElf()
                            subRaceController = 0
                        }

                        4 -> {
                            iSubRace = WoodElf()
                            subRaceController = 0
                        }

                        5 -> {
                            iSubRace = NoSubRace()
                            subRaceController = 0
                        }

                        else -> {
                            println("Opção inválida")
                        }
                    }

                } while (subRaceController != 0)
            }

            is Gnome -> {
                do {
                    println("\n  Menu Sub-Raça de Gnomo")

                    println("1 - Gnomo da Floresta")
                    println("2 - Gnomo das Rochas")
                    println("3 - Sem Sub-Raça")


                    print("\nEscolha sua Sub-Raça: ")
                    subRaceController = readln().toInt()

                    when (subRaceController) {
                        1 -> {
                            iSubRace = ForestGnome()
                            subRaceController = 0
                        }

                        2 -> {
                            iSubRace = RockGnome()
                            subRaceController = 0
                        }

                        3 -> {
                            iSubRace = NoSubRace()
                            subRaceController = 0
                        }

                        else -> {
                            println("Opção inválida")
                        }
                    }

                } while (subRaceController != 0)
            }

            is Halfling -> {
                do {
                    println("\n  Menu Sub-Raça de Halfling")

                    println("1 - Halfling Robusto")
                    println("2 - Halfling Pés-Leves")
                    println("3 - Sem Sub-Raça")

                    print("\nEscolha sua Sub-Raça: ")
                    subRaceController = readln().toInt()

                    when (subRaceController) {
                        1 -> {
                            iSubRace = StoutHalfling()
                            subRaceController = 0
                        }

                        2 -> {
                            iSubRace = LightfootHalfling()
                            subRaceController = 0
                        }

                        3 -> {
                            iSubRace = NoSubRace()
                            subRaceController = 0
                        }

                        else -> {
                            println("Opção inválida")
                        }
                    }

                } while (subRaceController != 0)
            }

            is HalfElves -> {
                iSubRace = NoSubRace()
            }

            is HalfOrcs -> {
                iSubRace = NoSubRace()
            }

            is Human -> {
                iSubRace = NoSubRace()
            }

            is Tiefling -> {
                iSubRace = NoSubRace()
            }
        }

        var classCharacterController: Int
        do {
            println("\n  Menu Classe")
            println("1 - Bárbaro")
            println("2 - Bardo")
            println("3 - Clérigo")
            println("4 - Druida")
            println("5 - Guerreiro")
            println("6 - Ladino")
            println("7 - Mago")
            println("8 - Monge")
            println("9 - Paladino")

            print("\nEscolha sua Classe: ")
            classCharacterController = readln().toInt()

            when (classCharacterController) {
                1 -> {
                    iClassCharacter = Barbarian()
                    classCharacterController = 0
                }

                2 -> {
                    iClassCharacter = Bard()
                    classCharacterController = 0
                }

                3 -> {
                    iClassCharacter = Cleric()
                    classCharacterController = 0
                }

                4 -> {
                    iClassCharacter = Druid()
                    classCharacterController = 0
                }

                5 -> {
                    iClassCharacter = Warrior()
                    classCharacterController = 0
                }

                6 -> {
                    iClassCharacter = Rogue()
                    classCharacterController = 0
                }

                7 -> {
                    iClassCharacter = Wizard()
                    classCharacterController = 0
                }

                8 -> {
                    iClassCharacter = Monk()
                    classCharacterController = 0
                }

                9 -> {
                    iClassCharacter = Paladin()
                    classCharacterController = 0
                }

                else -> {
                    println("Opção Inválida")
                    classCharacterController = 1
                }

            }

        } while (classCharacterController != 0)

        val defineRaceCharacter = DefineRaceCharacter(iRace, sheetDeD)
        val defineSubRaceCharacter = DefineRaceCharacter(iSubRace, sheetDeD)
        val defineClassCharacter = DefineClassCharacter(iClassCharacter, sheetDeD)

        sheetDeD = defineRaceCharacter.createRace()
        sheetDeD = defineSubRaceCharacter.createRace()
        sheetDeD = defineClassCharacter.createClassCharacter()

        var controllerLever: Int
        println()
        do {
            println("Level Atual: ${level.level}")
            print("Deseja aumentar 1 level? (S/N):")
            val response = readln().first().lowercaseChar()
            level.alterLevel += 1
            if (level.level < 20 && response == 's') {
                controllerLever = 1
            } else if (level.level == 20) {
                println("Level 20 atingido")
                controllerLever = 0
            } else {
                level.alterLevel -= 1
                controllerLever = 0
            }
        } while (controllerLever != 0)
        sheetDeD.level = level

        println("\nRaça: ${sheetDeD.race.nameRace}")
        println("Sub Raça: ${sheetDeD.subRace.nameRace}")
        println("Dislocamento: ${sheetDeD.displacement}")
        println("Classe: ${sheetDeD.classCharacter.nameClassCharacter}")
        println("Pontos de Vida: ${sheetDeD.hitPoints}")
        println("Level: ${sheetDeD.level.level}")

        println("\nLinguagens")
        println(sheetDeD.languages.joinToString(", ") { it.nameLanguage })

        println("\nAtributos")
        for (i in 0..5) {
            print("${sheetDeD.attributes[i].nameAttribute} ")
            print("${sheetDeD.attributes[i].valueAttribute} ")
        }

        println()
        println("\nCaracteristicas Especiais")
        println(sheetDeD.specialFeatures.joinToString(", ") { it.nameSpecialFeatures })

        println("\nPersonagem ${sheetDeD.characterSheet.nameCharacter} Criado com Sucesso")

        return sheetDeD
    }
}