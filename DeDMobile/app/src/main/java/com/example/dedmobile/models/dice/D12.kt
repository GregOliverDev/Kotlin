package org.example.models.dice

import kotlin.random.Random

class D12 {
    fun getRandomValue(): Int {
        val randomD12 = Random.nextInt(1, 12)
        return randomD12
    }
}