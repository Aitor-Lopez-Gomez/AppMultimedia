package com.example.calculadra.datos

import com.example.calculadra.modelo.Componente


class ListaComponentes : RepositorioComponentes{
    private val lista: MutableList<Componente> = mutableListOf()
    override fun nuevoComponente(c: Componente) {
        lista.add(c)
    }

    override fun actualizar(id: Int, c: Componente) {
        lista[id] = c
    }

    override fun borrar(id: Int) {
        lista.removeAt(id)
    }

    override fun buscar(id: Int) : Componente{
        return lista[id]
    }

    override fun longitud(): Int {
        return lista.size
    }
}