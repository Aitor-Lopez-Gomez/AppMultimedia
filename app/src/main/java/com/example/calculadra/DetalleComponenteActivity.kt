package com.example.calculadra

import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadra.datos.RepositorioSingleton

class DetalleComponenteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_componente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val posicion = intent.getIntExtra("posicion", -1)
        val lista = RepositorioSingleton.instance.listaComponentes
        if (posicion < 0 || posicion >= lista.longitud()) {
            finish()
            return
        }

        val componente = lista.buscar(posicion)

        val txtNombre = findViewById<TextView>(R.id.txtDetalleNombre)
        val txtMarca = findViewById<TextView>(R.id.txtDetalleMarca)
        val rbValoracion = findViewById<RatingBar>(R.id.rbDetalleValoracion)
        val txtValoracion = findViewById<TextView>(R.id.txtDetalleValoracion)
        val txtPuntuacion = findViewById<TextView>(R.id.txtDetallePuntuacion)
        val txtPrecio = findViewById<TextView>(R.id.txtDetallePrecio)
        val txtCategoria = findViewById<TextView>(R.id.txtDetalleCategoria)
        val txtDescripcion = findViewById<TextView>(R.id.txtDetalleDescripcion)
        val imgComponente = findViewById<ImageView>(R.id.imgDetalleComponente)

        txtNombre.text = componente.nombre
        txtMarca.text = componente.marca
        rbValoracion.rating = componente.valoracion
        txtValoracion.text = componente.valoracion.toString()
        txtPuntuacion.text = "${componente.valoracion} / 5"
        txtPrecio.text = "${componente.precio.toString()} €"
        txtCategoria.text = componente.categoria
        txtDescripcion.text = componente.descripcion
        if (componente.imagenUri != null){
            imgComponente.setImageURI(Uri.parse(componente.imagenUri))
        } else {
            imgComponente.setImageResource(componente.imagen)
        }

        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)

        btnVolver.setOnClickListener {
            finish()
        }

    }
}