package com.example.calculadra.datos
import com.example.calculadra.modelo.Componente
class RepositorioSingleton private constructor(){
    companion object {
        val instance = RepositorioSingleton()
    }

    val listaComponentes: RepositorioComponentes = ListaComponentes()
    init {
        poblar()
    }
    private fun poblar() {
        listaComponentes.nuevoComponente(
            Componente("RTX 5070", "NVIDIA", "Tarjeta gráfica",
                549.99, android.R.drawable.ic_menu_gallery,
                "12 GB GDDR7", 4.5f)
        )

        listaComponentes.nuevoComponente(
            Componente("Ryzen 7 7800X3D", "AMD", "Procesador",
                349.99, android.R.drawable.ic_menu_gallery,
                "8 núcleos y 16 hilos", 5f)
        )

        listaComponentes.nuevoComponente(
            Componente("Vengeance 32 GB", "Corsair", "Memoria RAM",
                99.99, android.R.drawable.ic_menu_gallery,
                "32 GB DDR5", 4f)
        )
        listaComponentes.nuevoComponente(
            Componente("RTX 5070", "NVIDIA", "Tarjeta gráfica",
                549.99, android.R.drawable.ic_menu_gallery,
                "12 GB GDDR7", 4.5f)
        )
        listaComponentes.nuevoComponente(
            Componente("RTX 5070", "NVIDIA", "Tarjeta gráfica",
                549.99, android.R.drawable.ic_menu_gallery,
                "12 GB GDDR7", 4.5f)
        )
        listaComponentes.nuevoComponente(
            Componente("RTX 5070", "NVIDIA", "Tarjeta gráfica",
                549.99, android.R.drawable.ic_menu_gallery,
                "12 GB GDDR7", 4.5f)
        )
    }
}