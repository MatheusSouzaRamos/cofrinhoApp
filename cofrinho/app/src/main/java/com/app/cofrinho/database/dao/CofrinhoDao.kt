package com.app.cofrinho.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.cofrinho.database.entity.Cofrinho
import kotlinx.coroutines.flow.Flow

@Dao
interface CofrinhoDao {
    @Query("SELECT * FROM cofrinho")
    fun findAll(): List<Cofrinho>

    @Query("SELECT * FROM cofrinho WHERE id = :id")
    fun findById(id: Long): Cofrinho

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cofrinho: Cofrinho)

    @Query("SELECT COUNT(*) FROM cofrinho")
    suspend fun count(): Int

    @Query("SELECT moeda1 + (moeda50 * 0.5) + (moeda25 * 0.25) + (moeda10 * 0.10) + (moeda5 * 0.05) + (nota2 * 2) AS TOTAL FROM cofrinho WHERE id = :id")
    suspend fun total(id: Long): Double

    @Query("SELECT moeda1 + moeda50 + moeda25 + moeda10 + moeda5 + nota2 AS TOTAL FROM cofrinho WHERE id = :id")
    suspend fun quantidade(id: Long): Long

    @Query("UPDATE cofrinho SET nome = :nome, meta = :meta WHERE id = :id")
    suspend fun edit(id: Long, nome: String, meta: Double)

    @Query("UPDATE cofrinho SET moeda1 = :moeda1, moeda50 = :moeda50, moeda25 = :moeda25, moeda10 = :moeda10, moeda5 = :moeda5, nota2 = :nota2 WHERE id = :id")
    suspend fun update(id: Long, moeda1: Long, moeda50: Long, moeda25: Long, moeda10: Long, moeda5: Long, nota2: Long)

    @Query("UPDATE cofrinho SET nome = 'Cofrinho', meta = 0, moeda1 = 0, moeda50 = 0, moeda25 = 0, moeda10 = 0, moeda5 = 0, nota2 = 0 WHERE id = :id")
    suspend fun reset(id: Long)
}