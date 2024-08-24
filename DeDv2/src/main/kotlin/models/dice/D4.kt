package org.example.models.dice

import kotlin.random.Random

class D4 {
    fun getRandomValue(): Int {
        val randomD4 = Random.nextInt(1, 4)
        return randomD4
    }
}