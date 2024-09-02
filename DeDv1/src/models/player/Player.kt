package models.player
import models.character.CharacterSheet

class Player(
    var characterSheet: List<CharacterSheet>,
    var id: Int,
    var name: String,
) {
}