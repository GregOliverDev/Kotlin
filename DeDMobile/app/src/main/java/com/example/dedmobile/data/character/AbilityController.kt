package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.Ability
import com.example.dedmobile.models.character.attributes.DefineAttributes

class AbilityController(context: Context) {
    private val databaseHelper = Database(context)

    fun getAbilities(): List<Ability> {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM abilities"
        val abilities = mutableListOf<Ability>()

        val attributes = DefineAttributes().defineAttributes().toList()

        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nameAbility = cursor.getString(cursor.getColumnIndexOrThrow("nameAbility"))
                val idAttributes = cursor.getInt(cursor.getColumnIndexOrThrow("idAttibute"))

                val ability = Ability(id, nameAbility, attributes[idAttributes - 1])
                abilities.add(ability)
            } while (cursor.moveToNext())
        }
        cursor.close()

        return abilities
    }

}