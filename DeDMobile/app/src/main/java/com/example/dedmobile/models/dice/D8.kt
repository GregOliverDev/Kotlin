package com.example.dedmobile.models.dice

import kotlin.random.Random

class D8 {
    fun getRandomValue(): Int {
        return Random.nextInt(1, 8)
    }
}