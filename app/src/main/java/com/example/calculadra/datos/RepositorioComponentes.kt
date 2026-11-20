package com.example.calculadra.datos

import  com.example.calculadra.modelo.Componente

interface RepositorioComponentes {
    fun nuevoComponente(c: Componente)
    fun actualizar(id: Int, c: Componente)
    fun borrar(id: Int)
    fun buscar(id: Int): Componente
    fun longitud(): Int

}