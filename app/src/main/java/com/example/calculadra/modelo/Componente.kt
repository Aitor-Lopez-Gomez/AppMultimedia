package com.example.calculadra.modelo

import android.R

data class Componente(
    var nombre: String,
    var marca: String,
    var categoria: String,
    var precio: Double,
    var imagen: Int,
    var descripcion: String = "",
    var valoracion: Float = 0f,
    var imagenUri: String? = null
)
