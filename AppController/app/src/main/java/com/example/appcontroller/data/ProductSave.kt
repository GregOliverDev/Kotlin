package com.example.appcontroller.data

import android.content.ContentValues
import android.content.Context
import com.example.appcontroller.models.Product

class ProductSave(context: Context) {
    private val databaseHelper = Database(context)
    fun insertProduct(name: String, price: Double): Boolean {
        if (name.isBlank()) {
            return false
        }
        val db = databaseHelper.readableDatabase
        val cursor = db.query(
            "products",
            arrayOf("name"),
            "name = ?",
            arrayOf(name),
            null, null, null
        )

        val exists = cursor.count > 0
        cursor.close()

        if (exists) {
            return false
        }

        val contentValues = ContentValues().apply {
            put("name", name)
            put("price", price)
        }

        val result = db.insert("products", null, contentValues)
        return result != -1L
    }

    fun getProducts(): List<Product>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM products"
        val cursor = db.rawQuery(query, null)

        val products = mutableListOf<Product>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))

                products.add(Product(id = id, name = name, price = price))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return products.ifEmpty { null }
    }

    fun getProductsLike(nameFilter: String): List<Product>? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM products WHERE name LIKE ?"
        val cursor = db.rawQuery(query, arrayOf("%$nameFilter%"))

        val products = mutableListOf<Product>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))

                products.add(Product(id = id, name = name, price = price))
            } while (cursor.moveToNext())
        }

        cursor.close()
        return products.ifEmpty { null }
    }

    fun getProductById(idFilter: Int): Product? {
        val db = databaseHelper.readableDatabase
        val query = "SELECT * FROM products WHERE id = ?"
        val cursor = db.rawQuery(query, arrayOf(idFilter.toString()))

        var product: Product? = null

        if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))

            product = Product(id = id, name = name, price = price)
        }

        cursor.close()
        return product
    }


    fun updateProduct(id: Int, newName: String, newPrice: Double): Boolean {
        val db = databaseHelper.writableDatabase
        val contentValues = ContentValues().apply {
            put("name", newName)
            put("price", newPrice)
        }
        val rowsAffected = db.update("products", contentValues, "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

    fun deleteProduct(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val rowsAffected = db.delete("products", "id = ?", arrayOf(id.toString()))
        db.close()
        return rowsAffected > 0
    }

}