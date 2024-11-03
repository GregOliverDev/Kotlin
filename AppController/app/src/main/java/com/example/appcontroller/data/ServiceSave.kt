package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.Service

class ServiceSave(context: Context) {
    private val databaseHelper = Database(context)
    fun insertService(name: String, price: Double): Boolean {
        if (name.isBlank()) {
            return false
        }
        val db = databaseHelper.readableDatabase
        val cursor = db.query(
            "services",
            arrayOf("name"),
            "name = ?",
            arrayOf(name),
            null, null, null
        )

        val exists = cursor.count > 0
        cursor.close()

        if (exists) {
            return false
        }

        val contentValues = ContentValues().apply {
            put("name", name)
            put("price", price)
        }

        val result = db.insert("services", null, contentValues)
        return result != -1L
    }

    fun getServices(): List<Service>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM services"
        val cursor = db.rawQuery(query, null)

        val services = mutableListOf<Service>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))

                services.add(Service(id = id, name = name, price = price))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return services.ifEmpty { null }
    }

    fun getServicesLike(nameFilter: String): List<Service>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM services WHERE name LIKE ?"
        val cursor = db.rawQuery(query, arrayOf("%$nameFilter%"))

        val services = mutableListOf<Service>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))

                services.add(Service(id = id, name = name, price = price))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return services.ifEmpty { null }
    }

    fun updateService(id: Int, newName: String, newPrice: Double): Boolean {
        val db = databaseHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("name", newName)
            put("price", newPrice)
        }
        val rowsAffected = db.update("services", contentValues, "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

    fun deleteService(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val rowsAffected = db.delete("services", "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

}