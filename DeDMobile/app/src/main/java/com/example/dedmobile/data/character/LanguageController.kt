package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.Language

class LanguageController(context: Context) {
    private val databaseHelper = Database(context)

    fun insertLanguage(languages: List<Language>, idSheetDeD: Int) {
        val db = databaseHelper.readableDatabase

        for (language in languages) {
            val values = ContentValues().apply {
                put("nameLanguage", language.nameLanguage)
                put("idSheetDeD", idSheetDeD)
            }
            db.insert("languages", null, values)
        }
    }

    fun getLanguages(idSheetDeD: Int): List<Language> {
        val db = databaseHelper.readableDatabase
        val languages = mutableListOf<Language>()

        val cursor = db.query(
            "languages",
            arrayOf("nameLanguage"),
            "idSheetDeD = ?",
            arrayOf(idSheetDeD.toString()),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val language = Language(
                    nameLanguage = cursor.getString(cursor.getColumnIndexOrThrow("nameLanguage"))
                )
                languages.add(language)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return languages
    }
}