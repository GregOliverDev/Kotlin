package org.example.models.dice

import kotlin.random.Random

class D8 {
    fun getRandomValue(): Int {
        val randomD8 = Random.nextInt(1, 8)
        return randomD8
    }
}