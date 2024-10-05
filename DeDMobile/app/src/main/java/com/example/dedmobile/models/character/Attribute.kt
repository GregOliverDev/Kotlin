package com.example.dedmobile.models.character

import com.example.dedmobile.models.Topic
import java.io.Serializable

class Attribute(
    var nameAttribute: String,
    var valueAttribute: Int
): Serializable {
    var valueAt: Int
        get() = this.valueAttribute
        set(value) {
            this.valueAttribute = value
            Topic.notify("valueAttribute", this.nameAttribute)
        }
}