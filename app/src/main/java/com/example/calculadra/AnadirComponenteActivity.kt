package com.example.calculadra

import android.net.Uri
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
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.calculadra.modelo.Componente
import com.example.calculadra.datos.RepositorioSingleton
import android.content.Intent

class AnadirComponenteActivity : AppCompatActivity() {
    private var imagenSeleccionadaUri: Uri? = null
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
        val imgVistaPrevia = findViewById<ImageView>(R.id.imgVistaPrevia)
        val btnSeleccionarImagen = findViewById<Button>(R.id.btnSeleccionarImagen)
        val posicion = intent.getIntExtra("posicion", -1)
        var imagenRecurso = R.drawable.ic_procesador
        val modoEdicion = posicion != -1
        if (modoEdicion) {
            val componente = RepositorioSingleton.instance.listaComponentes.buscar(posicion)
            imagenRecurso = componente.imagen
            edtNombre.setText(componente.nombre)
            edtMarca.setText(componente.marca)
            edtPrecio.setText(componente.precio.toString())
            edtDescripcion.setText(componente.descripcion)
            rbValoracion.rating = componente.valoracion
            spnCategoria.setSelection(categorias.indexOf(componente.categoria))
            if (componente.imagenUri != null) {
                imagenSeleccionadaUri = Uri.parse(componente.imagenUri)
                imgVistaPrevia.imageTintList = null
                imgVistaPrevia.setImageURI(imagenSeleccionadaUri)
            } else {
                imgVistaPrevia.imageTintList = null
                imgVistaPrevia.setImageResource(componente.imagen)
            }

        }
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
            val componente = Componente(nombre, marca, categoria, precio, imagenRecurso, descripcion, valoracion, imagenUri = imagenSeleccionadaUri?.toString())
            if (modoEdicion){
                RepositorioSingleton.instance.listaComponentes.actualizar(posicion, componente)
            } else {
                RepositorioSingleton.instance.listaComponentes.nuevoComponente(componente)
            }


            finish()
        }

        val selectorImagen = registerForActivityResult(ActivityResultContracts.OpenDocument()){
                uri -> if (uri != null){
            contentResolver.takePersistableUriPermission(uri,Intent.FLAG_GRANT_READ_URI_PERMISSION)
            imagenSeleccionadaUri = uri
            imgVistaPrevia.imageTintList = null
            imgVistaPrevia.setImageURI(uri)
            }
        }
        btnSeleccionarImagen.setOnClickListener {
            selectorImagen.launch(arrayOf("image/*"))
        }
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }


    }





}