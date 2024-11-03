package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.Vend

class VendSave(context: Context) {
    private val databaseHelper = Database(context)
    fun insertVend(idUser: Int, nameClient: String, dateVend: Date, priceFinal: Double): Boolean {
        if (nameClient.isBlank()) {
            return false
        }

        val contentValues = ContentValues().apply {
            put("idUser", idUser)
            put("nameClient", nameClient)
            put("dateVend", dateVend)
            put("priceFinal", priceFinal)
        }

        val result = db.insert("vends", null, contentValues)
        return result != -1L
    }

    fun getVends(): List<Vend>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM vends"
        val cursor = db.rawQuery(query, null)

        val vends = mutableListOf<Vend>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val idUser = cursor.getInt(cursor.getColumnIndexOrThrow("idUser"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("nameClient"))
                val dateVend = cursor.getString(cursor.getColumnIndexOrThrow("dateVend"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("priceFinal"))

                services.add(Service(id = id, idUser = idUser , nameClient = nameClient, dateVend = dateVend, priceFinal = priceFinal))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return vends.ifEmpty { null }
    }

    fun deleteVend(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val rowsAffected = db.delete("vends", "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

}