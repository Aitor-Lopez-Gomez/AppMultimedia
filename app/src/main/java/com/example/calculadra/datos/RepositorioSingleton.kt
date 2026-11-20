package com.example.calculadra.datos

class RepositorioSingleton private constructor(){
    companion object {
        val instance = RepositorioSingleton()
    }

    val listaComponentes: RepositorioComponentes = ListaComponentes()
}