package com.example.dedmobile.models.character

import com.example.dedmobile.models.Topic

class Level(private var level: Int, private var xp: Int) {
    var alterLevel: Int
        get() = this.level
        set(value) {
            this.level = value
            Topic.notify("alterLevel", this.level)
        }
}