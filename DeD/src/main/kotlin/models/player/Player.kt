package models.player
import models.character.SheetDeD

class Player(
    var characterSheet: List<SheetDeD>? = null,
    var id: Int,
    var namePlayer: String,
)