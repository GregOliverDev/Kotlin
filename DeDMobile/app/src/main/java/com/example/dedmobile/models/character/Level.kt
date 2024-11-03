package com.example.dedmobile.models.character

import com.example.dedmobile.models.Topic
import java.io.Serializable

class Level(private var level: Int, private var xp: Int): Serializable {
    var alterLevel: Int
        get() = this.level
        set(value) {
            this.level = value
            Topic.notify("alterLevel", this.level)
        }

    fun getLevel(): Int{
        return this.level
    }
}