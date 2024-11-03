package com.example.appcontroller.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "AppController.db"
        const val DATABASE_VERSION = 1
    }

    private val createUser =
        "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password TEXT)"

    private val createProduct =
        "CREATE TABLE products (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price REAL)"

    private val createService =
        "CREATE TABLE services (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price REAL)"

    private val createMov =
        "CREATE TABLE movs (id INTEGER PRIMARY KEY AUTOINCREMENT, idProduct INTEGER, idUser INTEGER, type INTEGER, dateMov TEXT , quant INTEGER, description TEXT, price REAL )"

    private val createStock =
        "CREATE TABLE stock (id INTEGER PRIMARY KEY AUTOINCREMENT, idProduct INTEGER, quant INTERGER)"

    private val createVend =
        "CREATE TABLE vends (id INTEGER PRIMARY KEY AUTOINCREMENT, idUser INTEGER, nameClient TEXT, dateVend TEXT)"

    private val createItensVend =
        "CREATE TABLE itensVend (id INTEGER PRIMARY KEY AUTOINCREMENT, idVend INTEGER, idProduct INTEGER, idService INTEGER, type TEXT , price REAL, discount REAL, quant INTEGER)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createUser)
        db?.execSQL(createProduct)
        db?.execSQL(createService)
        db?.execSQL(createMov)
        db?.execSQL(createStock)
        db?.execSQL(createVend)
        db?.execSQL(createItensVend)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        db?.execSQL("DROP TABLE IF EXISTS products")
        db?.execSQL("DROP TABLE IF EXISTS services")
        db?.execSQL("DROP TABLE IF EXISTS movs")
        db?.execSQL("DROP TABLE IF EXISTS stock")
        db?.execSQL("DROP TABLE IF EXISTS vends")
        db?.execSQL("DROP TABLE IF EXISTS itensVend")
        onCreate(db)
    }
}