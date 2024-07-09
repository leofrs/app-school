package com.example.schoolapp.model

import androidx.collection.ObjectList

data class NotasModel(
    val id: Int,
    val nome: String,
    val disciplina: String,
    val nota: Int,
    val notaFinal: Int
)
