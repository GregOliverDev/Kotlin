package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.ItensVend
import com.example.appcontroller.models.Vend

class ItensVendSave(context: Context) {
    private val databaseHelper = Database(context)

    fun insertIten(
        idVend: Int,
        idProduct: Int,
        idService: Int,
        type: String,
        price: Double,
        discount: Double,
        quant: Int
    ): Boolean {
        val db = databaseHelper.readableDatabase
        val contentValues = ContentValues().apply {
            put("idVend", idVend)
            put("idProduct", idProduct)
            put("idService", idService)
            put("type", type)
            put("price", price)
            put("discount", discount)
            put("quant", quant)
        }

        val result = db.insert("itensVend", null, contentValues)
        return result != -1L
    }

    fun getItensVend(): List<ItensVend>?{
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM itensVend"
        val cursor = db.rawQuery(query, null)

        val itens = mutableListOf<ItensVend>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val idVend = cursor.getInt(cursor.getColumnIndexOrThrow("idVend"))
                val idProduct = cursor.getInt(cursor.getColumnIndexOrThrow("idProduct"))
                val idService = cursor.getInt(cursor.getColumnIndexOrThrow("idService"))
                val type = cursor.getString(cursor.getColumnIndexOrThrow("type"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))
                val discount = cursor.getDouble(cursor.getColumnIndexOrThrow("discount"))
                val quant = cursor.getInt(cursor.getColumnIndexOrThrow("quant"))

                itens.add(
                    ItensVend(
                        id = id,
                        idVend = idVend,
                        idProduct = idProduct,
                        idService = idService,
                        type = type,
                        price = price,
                        discount = discount,
                        quant = quant,
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return itens.ifEmpty { null }
    }

    fun updateItensVend(id: Int, newQuant: Int, price: Double, discount: Double): Boolean{
        val db = databaseHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("quant", newQuant)
            put("price", price)
            put("discount", discount)
        }
        val rowsAffected = db.update("itensVend", contentValues, "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

    fun deleteItensVend(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val rowsAffected = db.delete("itensVend", "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }
}