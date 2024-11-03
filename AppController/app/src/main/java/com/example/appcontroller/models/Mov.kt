package com.example.appcontroller.models

import java.io.Serializable
import java.util.Date

class Mov(
    var id: Int,
    var idProduct: Int,
    var idUser: Int,
    var type: Int,
    var dateMov: String,
    var quant: Int,
    var description: String,
    var price: Double
) : Serializable