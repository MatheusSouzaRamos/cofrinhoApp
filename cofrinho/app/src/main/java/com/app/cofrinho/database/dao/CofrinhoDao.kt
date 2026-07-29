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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cofrinho: Cofrinho)

    @Query("SELECT COUNT(*) FROM cofrinho")
    suspend fun count(): Int
}