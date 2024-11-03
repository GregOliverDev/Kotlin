package com.example.appcontroller.models

import java.io.Serializable
import java.util.Date

class Vend(
    var id: Int,
    var idUser: Int,
    var nameClient: String,
    var dateVend: String,
    var priceFinal: Double
) : Serializable