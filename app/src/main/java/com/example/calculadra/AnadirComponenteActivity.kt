package com.example.calculadra

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Button
import com.example.calculadra.modelo.Componente
import com.example.calculadra.datos.RepositorioSingleton

class AnadirComponenteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_anadir_componente)
        val spnCategoria = findViewById<Spinner>(R.id.spnCategoria)
        val categorias = listOf(
            "Procesador",
            "Tarjeta gráfica",
            "Memoria RAM",
            "Almacenamiento",
            "Placa base",
            "Fuente de alimentación",
            "Refrigeración",
            "Otros"
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCategoria.adapter = adaptador
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNombre = findViewById<EditText>(R.id.edtNombre)
        val edtMarca = findViewById<EditText>(R.id.edtMarca)
        val edtPrecio = findViewById<EditText>(R.id.edtPrecio)
        val edtDescripcion = findViewById<EditText>(R.id.edtDescripcion)
        val rbValoracion = findViewById<RatingBar>(R.id.rbValoracionNueva)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarComponente)
        btnGuardar.setOnClickListener {
            val nombre = edtNombre.text.toString().trim()
            val marca = edtMarca.text.toString().trim()
            val categoria = spnCategoria.selectedItem.toString()
            val precio = edtPrecio.text.toString().toDoubleOrNull()
            val descripcion = edtDescripcion.text.toString().trim()
            val valoracion = rbValoracion.rating

            if (nombre.isEmpty()){
                edtNombre.error = "Introduce un nombre"
                return@setOnClickListener
            }
            if (marca.isEmpty()) {
                edtMarca.error = "Introduce una marca"
                return@setOnClickListener
            }

            if (precio == null || precio <= 0) {
                edtPrecio.error = "Introduce un precio válido"
                return@setOnClickListener
            }
            val componente = Componente(nombre, marca, categoria, precio, R.drawable.ic_procesador, descripcion, valoracion)
            RepositorioSingleton.instance.listaComponentes.nuevoComponente(componente)

            finish()
        }


        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }


    }




}