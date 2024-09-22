package com.example.dedmobile.models.player

import com.example.dedmobile.models.character.SheetDeD
import java.io.Serializable

class Player(
    var characterSheet: List<SheetDeD>? = null,
    var id: Int,
    var namePlayer: String,
    var password: String
): Serializable