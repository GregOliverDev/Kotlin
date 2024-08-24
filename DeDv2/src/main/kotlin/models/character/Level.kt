package models.character

import org.example.models.Topic

class Level(var level: Int, var xp: Int) {
    var alterLevel: Int
        get() = this.level
        set(value) {
            this.level = value
            Topic.notify("alterLevel", this.level)
        }
}