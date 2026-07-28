package com.app.cofrinho.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cofrinho")
data class Cofrinho (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val nome: String,
    val meta: Double,

    val img: Long,

    val moeda1: Long = 0,
    val moeda50: Long = 0,
    val moeda25: Long = 0,
    val moeda10: Long = 0,
    val moeda5: Long = 0,
    val nota2: Long = 0,
    val nota5: Long = 0,
    val nota10: Long = 0
)