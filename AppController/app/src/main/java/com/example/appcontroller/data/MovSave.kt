package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.Mov
import java.util.Date

class MovSave(context: Context) {
    private val databaseHelper = Database(context)
    fun insertMov(
        idProduct: Int,
        idUser: Int,
        type: Int,
        dateMov: String,
        quant: Int,
        description: String,
        price: Double
    ): Boolean {

        val db = databaseHelper.readableDatabase

        val contentValues = ContentValues().apply {
            put("idProduct", idProduct)
            put("idUser", idUser)
            put("type", type)
            put("dateMov", dateMov)
            put("quant", quant)
            put("description", description)
            put("price", price)
        }

        val result = db.insert("movs", null, contentValues)
        return result != -1L
    }

    fun getMovs(): List<Mov>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM movs"
        val cursor = db.rawQuery(query, null)

        val movs = mutableListOf<Mov>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val idProduct = cursor.getInt(cursor.getColumnIndexOrThrow("idProduct"))
                val idUser = cursor.getInt(cursor.getColumnIndexOrThrow("idUser"))
                val type = cursor.getInt(cursor.getColumnIndexOrThrow("type"))
                val dateMov = cursor.getString(cursor.getColumnIndexOrThrow("dateMov"))
                val quant = cursor.getInt(cursor.getColumnIndexOrThrow("quant"))
                val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))

                movs.add(
                    Mov(
                        id = id,
                        idProduct = idProduct,
                        idUser = idUser,
                        type = type,
                        dateMov = dateMov,
                        quant = quant,
                        description = description,
                        price = price
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor.close()
        return movs.ifEmpty { null }
    }

    fun deleteMov(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val rowsAffected = db.delete("movs", "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

}