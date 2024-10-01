package com.example.dedmobile.data

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
        "CREATE TABLE players (id INTEGER PRIMARY KEY AUTOINCREMENT, namePlayer TEXT, password TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createPlayer)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS players")
        onCreate(db)
    }


}