package org.example.models.dice

import kotlin.random.Random

class D10 {
    fun getRandomValue(): Int {
        val randomD10 = Random.nextInt(1, 10)
        return randomD10
    }
}