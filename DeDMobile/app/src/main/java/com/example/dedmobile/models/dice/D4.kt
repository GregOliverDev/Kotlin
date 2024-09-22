package com.example.dedmobile.models.dice

import kotlin.random.Random

class D4 {
    fun getRandomValue(): Int {
        return Random.nextInt(1, 4)
    }
}