package com.example.appcontroller.models

import java.io.Serializable

class ItensVend(
    var id: Int,
    var idVend: Int,
    var idProduct: Int,
    var idService: Int,
    var type: String,
    var price: Double,
    var discount: Double,
    var quant: Int
) :
    Serializable