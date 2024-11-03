package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.Stock

class StockSave(context: Context) {
    private val databaseHelper = Database(context)
    fun insertStock(idProduct: Int, quant: Int): Boolean {
        val db = databaseHelper.readableDatabase
        val cursor = db.query(
            "stock",
            arrayOf("idProduct"),
            "idProduct = ?",
            arrayOf(idProduct.toString()),
            null, null, null
        )

        val exists = cursor.count > 0
        cursor.close()

        if (exists) {
            return false
        }

        val contentValues = ContentValues().apply {
            put("idProduct", idProduct)
            put("quant", quant)
        }

        val result = db.insert("stock", null, contentValues)
        return result != -1L
    }

    fun getStock(): List<Stock>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM stock"
        val cursor = db.rawQuery(query, null)

        val stock = mutableListOf<Stock>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val idProduct = cursor.getInt(cursor.getColumnIndexOrThrow("idProduct"))
                val quant = cursor.getInt(cursor.getColumnIndexOrThrow("quant"))

                stock.add(Stock(id = id, idProduct = idProduct, quant = quant))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return stock.ifEmpty { null }
    }

    fun updateStock(id: Int, newQuant: Double): Boolean {
        val db = databaseHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("quant", newQuant)
        }
        val rowsAffected = db.update("stock", contentValues, "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

    fun deleteStock(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val rowsAffected = db.delete("stock", "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

}