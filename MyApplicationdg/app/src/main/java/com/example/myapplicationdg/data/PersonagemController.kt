package com.example.myapplicationdg.data

import android.content.ContentValues
import android.content.Context
import com.example.myapplicationdg.jogo.personagens.Personagem
import org.example.racas.Anao
import org.example.racas.Humano
import org.example.racas.Raca
import racas.MeioElfo
import racas.MeioOrc
import racas.Draconato
import racas.Elfo
import racas.Gnomo
import racas.Halfling
import racas.Tiefling


class PersonagemController(context: Context) {
    private val databaseHelper = Database(context)

    fun insertPersonagem(personagem: Personagem, raca: String): Boolean {
        val db = databaseHelper.writableDatabase
        val value = ContentValues().apply {
            put("raca", raca)
            put("forca", personagem.forca)
            put("destreza", personagem.destreza)
            put("constituicao", personagem.constituicao)
            put("inteligencia", personagem.inteligencia)
            put("sabedoria", personagem.sabedoria)
            put("carisma", personagem.carisma)
            put("nome", personagem.nome)
            put("descricao", personagem.descricao)
            put("idade", personagem.idade)
            put("genero", personagem.genero)
            put("vida", personagem.vida)
        }

        val result = db.insert("personagens", null, value)
        return result != -1L
    }

    fun getPersonagem(id: Int): Personagem? {
        val db = databaseHelper.readableDatabase
        val cursor = db.query(
            "personagens",
            arrayOf(
                "id",
                "raca",
                "forca",
                "destreza",
                "constituicao",
                "inteligencia",
                "sabedoria",
                "carisma",
                "nome",
                "descricao",
                "idade",
                "genero",
                "vida"
            ),
            "id = ?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            val racaPer = cursor.getString(cursor.getColumnIndexOrThrow("raca"))
            val racaAux: Raca = when (racaPer) {
                "Anao" -> Anao()
                "Draconato" -> Draconato()
                "Elfo" -> Elfo()
                "Gnomo" -> Gnomo()
                "Halfling" -> Halfling()
                "Humano" -> Humano()
                "MeioElfo" -> MeioElfo()
                "MeioOrc" -> MeioOrc()
                "Tiefling" -> Tiefling()

                else -> Anao()

            }

            val personagem = Personagem(
                raca = racaAux
            )
            personagem.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            personagem.forca = cursor.getInt(cursor.getColumnIndexOrThrow("forca"))
            personagem.destreza = cursor.getInt(cursor.getColumnIndexOrThrow("destreza"))
            personagem.constituicao = cursor.getInt(cursor.getColumnIndexOrThrow("constituicao"))
            personagem.inteligencia = cursor.getInt(cursor.getColumnIndexOrThrow("inteligencia"))
            personagem.sabedoria = cursor.getInt(cursor.getColumnIndexOrThrow("sabedoria"))
            personagem.carisma = cursor.getInt(cursor.getColumnIndexOrThrow("carisma"))
            personagem.nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"))
            personagem.descricao = cursor.getString(cursor.getColumnIndexOrThrow("descricao"))
            personagem.idade = cursor.getInt(cursor.getColumnIndexOrThrow("idade"))
            personagem.genero = cursor.getString(cursor.getColumnIndexOrThrow("genero"))
            personagem.vida = cursor.getInt(cursor.getColumnIndexOrThrow("vida"))
            cursor.close()
            personagem
        } else {
            cursor.close()
            null
        }
    }

    fun update(id: Int, personagem: Personagem) {
        val db = databaseHelper.writableDatabase
        val values = ContentValues().apply {
            put("forca", personagem.forca)
            put("destreza", personagem.destreza)
            put("constituicao", personagem.constituicao)
            put("inteligencia", personagem.inteligencia)
            put("sabedoria", personagem.sabedoria)
            put("carisma", personagem.carisma)
            put("vida", personagem.vida)
        }

        val whereClause = "id = ?"
        val whereArgs = arrayOf(id.toString())

        db.update("personagens", values, whereClause, whereArgs)
    }

    fun deletePersonagem(id: Int): Boolean {
        val db = databaseHelper.writableDatabase
        val result = db.delete("personagens", "id=?", arrayOf(id.toString()))
        db.close()
        return result > 0 // Retorna true se a exclusão foi bem-sucedida
    }


}