package com.example.myapplicationdg.data

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "Durngeons.db"
        const val DATABASE_VERSION = 1
    }

    private val createPersonagem =
        "CREATE TABLE personagens (id INTEGER PRIMARY KEY AUTOINCREMENT, forca INTEGER, destreza INTEGER, constituicao INTEGER, inteligencia INTEGER, sabedoria INTEGER, carisma INTEGER, nome TEXT, descricao TEXT, idade INTEGER, genero TEXT, vida INTEGER, raca TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createPersonagem)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS personagens")
        onCreate(db)

    }


}

