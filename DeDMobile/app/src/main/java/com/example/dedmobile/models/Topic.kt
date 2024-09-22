package com.example.dedmobile.models

object Topic {
    private val observers = mutableMapOf<String, (Any?) -> Unit>()

    fun subscribe(key: String, function: (Any?) -> Unit) {
        if (observers.containsKey(key)) return
        observers[key] = function
    }

    fun notify(key: String, value: Any?) {
        observers[key]?.invoke(value)
    }

}