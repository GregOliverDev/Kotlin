package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.Character

class CharacterController(context: Context) {
    private val databaseHelper = Database(context)

    fun insertCharacter(character: Character): Boolean {
        val db = databaseHelper.readableDatabase
        val value = ContentValues().apply {
            put("age", character.age)
            put("gender", character.gender)
            put("indexImage", character.indexImage)
            put("nameCharacter", character.nameCharacter)
            put("physicalDescription", character.physicalDescription)
        }

        val result = db.insert("characters", null, value)
        return result != -1L
    }

    fun getCharacter(id: Int): Character? {
        val db = databaseHelper.readableDatabase
        val cursor = db.query(
            "characters",
            arrayOf("id", "age", "gender", "indexImage", "nameCharacter", "physicalDescription"),
            "id = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            val character = Character(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                age = cursor.getInt(cursor.getColumnIndexOrThrow("age")),
                gender = cursor.getString(cursor.getColumnIndexOrThrow("gender")),
                indexImage = cursor.getInt(cursor.getColumnIndexOrThrow("indexImage")),
                nameCharacter = cursor.getString(cursor.getColumnIndexOrThrow("nameCharacter")),
                physicalDescription = cursor.getString(cursor.getColumnIndexOrThrow("physicalDescription"))
            )
            cursor.close()
            character
        } else {
            cursor.close()
            null
        }
    }

    fun getMaxId(): Int? {
        val db = databaseHelper.readableDatabase
        var maxId: Int? = null
        val query = "SELECT MAX(id) FROM characters"

        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            maxId = cursor.getInt(0)
        }
        cursor.close()
        db.close()

        return maxId
    }

    fun deleteCharacter(id: Int) {
        val db = databaseHelper.writableDatabase
        val whereClause = "id = ?"
        val whereArgs = arrayOf(id.toString())

        db.delete("characters", whereClause, whereArgs)
    }

}