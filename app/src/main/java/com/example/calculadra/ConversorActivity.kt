package com.example.calculadra

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.ImageButton
class ConversorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imgIconoJuego)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cantidad = findViewById<EditText>(R.id.cantidad)
        val monedaOrigen = findViewById<Spinner>(R.id.monedaOrigen)
        val monedaDestino = findViewById<Spinner>(R.id.monedaDestino)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)
        val resultado = findViewById<TextView>(R.id.resultado)
        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)

        btnConvertir.setOnClickListener {
            if (cantidad.text.toString().isEmpty()) {
                cantidad.error = "Introduce una cantidad"
                return@setOnClickListener
            }

            val valor = cantidad.text.toString().replace(",", ".").toDoubleOrNull()

            if (valor == null) {
                cantidad.error = "Introduce una cantidad válida"
                return@setOnClickListener
            }
            val origen = monedaOrigen.selectedItemPosition
            val destino = monedaDestino.selectedItemPosition

            val euros = when (origen) {
                1 -> valor / 1.10
                2 -> valor / 0.85
                else -> valor
            }

            val conversion = when (destino) {
                1 -> euros * 1.10
                2 -> euros * 0.85
                else -> euros
            }

            resultado.text = String.format("%.2f €", conversion)
        }

        btnVolver.setOnClickListener {
            finish()
        }


    }
}