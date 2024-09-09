package org.example.models.character.language

class DefineLanguage {
    fun defineLanguageRace(): String {
        var controller: Int
        var nameLanguage = ""
        do {
            println("\n  Escolha uma Linguagem adicional")
            println("\n1 Élfico")
            println("2 Anão ")
            println("3 Dracônico ")
            println("4 Orc ")
            println("5 Gigante ")
            println("6 Gnômico ")

            print("\nSua Escolha: ")
            controller = readln().toInt()

            when (controller) {
                1 -> {
                    nameLanguage = "Élfico"
                    controller = 0
                }

                2 -> {
                    nameLanguage = "Anão"
                    controller = 0
                }

                3 -> {
                    nameLanguage = "Dracônico"
                    controller = 0
                }

                4 -> {
                    nameLanguage = "Orc"
                    controller = 0
                }

                5 -> {
                    nameLanguage = "Gigante"
                    controller = 0
                }

                6 -> {
                    nameLanguage = "Gnômico"
                    controller = 0
                }

                else -> {
                    println("Opção Inválida")
                    controller = 1
                }

            }
        } while (controller != 0)

        return nameLanguage
    }
}