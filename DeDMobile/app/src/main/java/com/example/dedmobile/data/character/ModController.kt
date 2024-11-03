package com.example.dedmobile.data.character

import android.content.ContentValues
import android.content.Context
import com.example.dedmobile.data.Database
import com.example.dedmobile.models.character.Mod

class ModController(context: Context) {
    private val databaseHelper = Database(context)

    fun insertMod(mods: List<Mod>, idSheetDeD: Int ) {
        val db = databaseHelper.writableDatabase
        for(mod in mods){
            val values = ContentValues().apply {
                put("nameMod", mod.nameMod)
                put("valueMod", mod.valueMod)
                put("idSheetDeD", idSheetDeD)
            }

            db.insert("mods", null, values)
        }
    }

    fun getMods(idSheetDeD: Int): List<Mod> {
        val db = databaseHelper.readableDatabase
        val mods = mutableListOf<Mod>()

        val cursor = db.query(
            "mods",
            arrayOf("id", "nameMod", "valueMod", "idSheetDeD"),
            "idSheetDeD = ?",
            arrayOf(idSheetDeD.toString()),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            do {
                val mod = Mod(
                    nameMod = cursor.getString(cursor.getColumnIndexOrThrow("nameMod")),
                    valueMod = cursor.getInt(cursor.getColumnIndexOrThrow("valueMod")),
                )
                mods.add(mod)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return mods
    }

    fun updateMods(mods: List<Mod>, idSheetDeD: Int) {
        val db = databaseHelper.writableDatabase

        for (mod in mods) {
            val values = ContentValues().apply {
                put("valueMod", mod.valueMod)
            }

            db.update(
                "mods",
                values,
                "nameMod = ? AND idSheetDeD = ?",
                arrayOf(mod.nameMod, idSheetDeD.toString())
            )
        }
    }

    fun deleteMods(idSheetDeD: Int) {
        val db = databaseHelper.writableDatabase
        val whereClause = "idSheetDeD = ?"
        val whereArgs = arrayOf(idSheetDeD.toString())

        db.delete("mods", whereClause, whereArgs)
    }

}