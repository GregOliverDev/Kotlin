package models.character

import org.example.models.Topic

class Attribute(
    var nameAttribute: String,
    var valueAttribute: Int
){
    var valueAt: Int
        get() = this.valueAttribute
        set(value) {
            this.valueAttribute = value
            Topic.notify("valueAttribute", this.nameAttribute)
        }
}