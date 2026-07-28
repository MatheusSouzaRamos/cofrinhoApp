package com.app.cofrinho.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.cofrinho.database.dao.CofrinhoDao
import com.app.cofrinho.database.entity.Cofrinho

@Database(entities = [Cofrinho::class], version = 1)
abstract class CofrinhoDatabase : RoomDatabase() {
    abstract fun cofrinhoDao(): CofrinhoDao
}