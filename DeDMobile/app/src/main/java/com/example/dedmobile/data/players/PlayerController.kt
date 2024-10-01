package com.example.dedmobile.data.players

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.player.Player

class PlayerController(context: Context) {
    private val databaseHelper = Database(context)
    fun insertPlayer(namePlayer: String, password: String): Boolean {
        if (namePlayer.isBlank() || password.isBlank()) {
            return false
        }

        val db = databaseHelper.writableDatabase

        val contentValues = ContentValues().apply {
            put("namePlayer", namePlayer)
            put("password", password)
        }

        val result = db.insert("players", null, contentValues)
        return result != -1L
    }

    fun getPlayer(namePlayer: String, password: String): Player? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM players WHERE namePlayer = ? AND password = ?"

        val cursor = db.rawQuery(query, arrayOf(namePlayer, password))

        return if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("namePlayer"))
            val pass = cursor.getString(cursor.getColumnIndexOrThrow("password"))

            Player(id = id, namePlayer = name, password = pass)
        } else {
            null
        }.also {
            cursor.close()
        }
    }
    /*
        fun updatePlayer(id: Int, namePlayer: String, password: String): Boolean {
            val db = databaseHelper.writableDatabase
            val contentValues = ContentValues().apply {
                put("password", password)
            }

            val result = db.update("players", contentValues, "id = ?", arrayOf(id.toString()))
            db.close()
            return result > 0
        }

        fun deletePlayer(id: Int): Boolean {
            val db = databaseHelper.writableDatabase
            val result = db.delete("players", "id = ?", arrayOf(id.toString()))
            db.close()
            return result > 0
        }*/
}
