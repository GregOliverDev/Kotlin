package org.example.models.dice

import kotlin.random.Random

class D6  {
     fun getRandomValue(): Int {
        val randomD6 = Random.nextInt(1, 6)
        return randomD6
    }
}