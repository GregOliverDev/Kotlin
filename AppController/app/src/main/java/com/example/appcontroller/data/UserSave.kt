package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.User

class UserSave(context: Context) {
    private val databaseHelper = Database(context)
    fun insertUser(name: String, password: String): Boolean {
        if (name.isBlank() || password.isBlank()) {
            return false
        }
        val db = databaseHelper.readableDatabase
        val cursor = db.query(
            "users",
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
            put("password", password)
        }

        val result = db.insert("users", null, contentValues)
        return result != -1L
    }

    fun getUser(name: String, password: String): User? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM users WHERE name = ? AND password = ?"

        val cursor = db.rawQuery(query, arrayOf(name, password))

        return if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val nameUser = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val pass = cursor.getString(cursor.getColumnIndexOrThrow("password"))

            User(id = id, name = nameUser, password = pass)
        } else {
            null
        }.also {
            cursor.close()
        }
    }

    fun updateUser(id: Int, newPass: String): Boolean {
        val db = databaseHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("password", newPass)
        }
        val rowsAffected = db.update("users", contentValues, "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

}