package com.app.cofrinho.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.cofrinho.database.dao.CofrinhoDao
import com.app.cofrinho.database.entity.Cofrinho

@Database(entities = [Cofrinho::class], version = 1)
abstract class CofrinhoDatabase : RoomDatabase() {
    abstract fun cofrinhoDao(): CofrinhoDao

    companion object {
        @Volatile
        private var INSTANCE: CofrinhoDatabase? = null
        fun getDatabase(context: Context): CofrinhoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CofrinhoDatabase::class.java,
                    "cofrinho.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}