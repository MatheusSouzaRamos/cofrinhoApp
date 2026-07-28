package com.app.cofrinho.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.cofrinho.entity.Cofrinho
import kotlinx.coroutines.flow.Flow

@Dao
interface CofrinhoDao {
    @Query("SELECT * FROM cofrinho")
    fun findAll(): Flow<List<Cofrinho>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cofrinho: Cofrinho)

    @Query("DELETE FROM cofrinho WHERE id = :cofrinhoId")
    fun deleteById(cofrinhoId: Long)
}