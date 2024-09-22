package com.example.dedmobile.models.player

class FindPlayer {
    fun findPlayerByName(namePlayer: String, password: String): Player? {
        return if(namePlayer == "dev"){
            if (password == "dev") {
                Player(null, 1, "devteste", "dev")
            }else{
                null
            }
        }else{
            null
        }
    }
}