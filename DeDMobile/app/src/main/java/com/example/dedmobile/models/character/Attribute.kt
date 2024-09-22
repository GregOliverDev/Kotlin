package com.example.dedmobile.models.character

import com.example.dedmobile.models.Topic

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