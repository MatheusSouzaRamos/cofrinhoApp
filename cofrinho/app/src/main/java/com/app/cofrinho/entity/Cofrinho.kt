package com.app.cofrinho.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cofrinho")
data class Cofrinho (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nome: String,
    val meta: Double,
    val moeda1: Long,
    val moeda50: Long,
    val moeda25: Long,
    val moeda10: Long,
    val moeda5: Long,
    val nota2: Long,
    val nota5: Long,
    val nota10: Long
)