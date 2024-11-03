package com.example.dedmobile.models.player

import com.example.dedmobile.models.character.SheetDeD
import java.io.Serializable

class Player(
    var idSheetDeD: Int,
    var id: Int,
    var namePlayer: String,
    var password: String
): Serializable