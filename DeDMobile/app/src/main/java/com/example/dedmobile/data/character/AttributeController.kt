package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.Attribute

class AttributeController(context: Context) {
    private val databaseHelper = Database(context)

    fun insertAttribute(attributes: List<Attribute>, idSheetDeD: Int) {
        val db = databaseHelper.writableDatabase
        for (attribute in attributes) {
            val values = ContentValues().apply {
                put("nameAttribute", attribute.nameAttribute)
                put("valueAttribute", attribute.valueAttribute)
                put("idSheetDeD", idSheetDeD)
            }
            db.insert("attributes", null, values)
        }
    }

    fun getAttributes(idSheetDeD: Int): List<Attribute> {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM attributes WHERE idSheetDeD = ?"
        val attributes = mutableListOf<Attribute>()

        val cursor = db.rawQuery(query, arrayOf(idSheetDeD.toString()))
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nameAttribute = cursor.getString(cursor.getColumnIndexOrThrow("nameAttribute"))
                val valueAttribute = cursor.getInt(cursor.getColumnIndexOrThrow("valueAttribute"))

                val attribute = Attribute(nameAttribute, valueAttribute)
                attributes.add(attribute)
            } while (cursor.moveToNext())
        }
        cursor.close()

        return attributes
    }

    fun updateAttributeValue(idSheetDeD: Int, nameAttribute: String, newValue: Int) {
        val db = databaseHelper.writableDatabase
        val values = ContentValues().apply {
            put("valueAttribute", newValue)
        }

        val whereClause = "idSheetDeD = ? AND nameAttribute = ?"
        val whereArgs = arrayOf(idSheetDeD.toString(), nameAttribute)

        db.update("attributes", values, whereClause, whereArgs)
    }
}