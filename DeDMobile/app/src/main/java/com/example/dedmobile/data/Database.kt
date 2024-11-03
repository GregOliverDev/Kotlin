package com.example.dedmobile.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "DeD.db"
        const val DATABASE_VERSION = 1
    }

    private val createPlayer =
        "CREATE TABLE players (id INTEGER PRIMARY KEY AUTOINCREMENT, namePlayer TEXT, password TEXT, idSheet INTEGER)"

    private val createAbility =
        "CREATE TABLE abilities (id INTEGER PRIMARY KEY AUTOINCREMENT, nameAbility TEXT, idAttibute INTEGER)"

    private val createAttribute =
        "CREATE TABLE attributes (id INTEGER PRIMARY KEY AUTOINCREMENT, nameAttribute TEXT, valueAttribute INTEGER, idSheetDeD INTEGER)"

    private val createCharacter =
        "CREATE TABLE characters (id INTEGER PRIMARY KEY AUTOINCREMENT, age INTEGER, gender TEXT, indexImage INTEGER, nameCharacter TEXT, physicalDescription TEXT)"

    private val createLanguage =
        "CREATE TABLE languages (id INTEGER PRIMARY KEY AUTOINCREMENT, nameLanguage TEXT, idSheetDeD INTEGER)"

    private val createMod =
        "CREATE TABLE mods (id INTEGER PRIMARY KEY AUTOINCREMENT, nameMod TEXT,valueMod INTEGER, idSheetDeD INTEGER)"

    private val createSpecialFeature =
        "CREATE TABLE specialFeatures (id INTEGER PRIMARY KEY AUTOINCREMENT, nameSpecialFeatures TEXT, idSheetDeD INTEGER )"

    private val createSheetDeD =
        "CREATE TABLE sheets (id INTEGER PRIMARY KEY AUTOINCREMENT, amountDiceLive INTEGER, race TEXT, idCharacter INTEGER, classeCharacter TEXT, currentHitPoints INTEGER, diceLive TEXT, displacement INTEGER, hitPoints INTEGER, level INTEGER, subRace TEXT, temporaryHitPoints INTEGER)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createPlayer)
        db?.execSQL(createAbility)
        db?.execSQL(createAttribute)
        db?.execSQL(createCharacter)
        db?.execSQL(createLanguage)
        db?.execSQL(createMod)
        db?.execSQL(createSpecialFeature)
        db?.execSQL(createSheetDeD)
        if (db != null) {
            insertDefaultAbilities(db)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS players")
        db?.execSQL("DROP TABLE IF EXISTS abilities")
        db?.execSQL("DROP TABLE IF EXISTS attributes")
        db?.execSQL("DROP TABLE IF EXISTS characters")
        db?.execSQL("DROP TABLE IF EXISTS languages")
        db?.execSQL("DROP TABLE IF EXISTS mods")
        db?.execSQL("DROP TABLE IF EXISTS specialFeatures")
        db?.execSQL("DROP TABLE IF EXISTS sheets")
        onCreate(db)
    }

    private fun insertDefaultAbilities(db: SQLiteDatabase) {
        val abilities = listOf(
            Pair("Atletismo", 1),
            Pair("Acrobacia", 2),
            Pair("Furtividade", 1),
            Pair("Prestidigitação", 1),
            Pair("Arcanismo", 4),
            Pair("História", 4),
            Pair("Investigação", 4),
            Pair("Natureza", 4),
            Pair("Religião", 4),
            Pair("Intuição", 5),
            Pair("Medicina", 5),
            Pair("Percepção", 5),
            Pair("Sobrevivência", 5),
            Pair("Trato com Animais", 5),
            Pair("Enganação", 6),
            Pair("Intimidação", 6),
            Pair("Performance", 6),
            Pair("Persuasão", 6),
        )

        for (ability in abilities) {
            val values = ContentValues().apply {
                put("nameAbility", ability.first)
                put("idAttibute", ability.second)
            }
            db.insert("abilities", null, values)
        }
    }
}