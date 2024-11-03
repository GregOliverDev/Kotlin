package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.SpecialFeature

class SpecialFeatureController(context: Context) {
    private val databaseHelper = Database(context)

    fun insertSpecialFeatures(specialFeatures: List<SpecialFeature>, idSheetDeD: Int) {
        val db = databaseHelper.writableDatabase

        for (feature in specialFeatures) {
            val values = ContentValues().apply {
                put("nameSpecialFeatures", feature.nameSpecialFeatures)
                put("idSheetDeD", idSheetDeD)
            }

            db.insert("specialFeatures", null, values)
        }
    }


    fun getSpecialFeatures(idSheetDeD: Int): List<SpecialFeature> {
        val db = databaseHelper.readableDatabase
        val specialFeatures = mutableListOf<SpecialFeature>()

        val cursor = db.query(
            "specialFeatures",
            arrayOf("nameSpecialFeatures"),
            "idSheetDeD = ?",
            arrayOf(idSheetDeD.toString()),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val specialFeature = SpecialFeature(
                    nameSpecialFeatures = cursor.getString(cursor.getColumnIndexOrThrow("nameSpecialFeatures"))
                )
                specialFeatures.add(specialFeature)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return specialFeatures
    }

    fun deleteSpecialFeatures(idSheetDeD: Int) {
        val db = databaseHelper.writableDatabase
        val whereClause = "idSheetDeD = ?"
        val whereArgs = arrayOf(idSheetDeD.toString())

        db.delete("specialFeatures", whereClause, whereArgs)
    }
}