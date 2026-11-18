package com.example.calculadra

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MinijuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_minijuego)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val txtVictorias = findViewById<TextView>(R.id.victorias)
        val txtEmpates = findViewById<TextView>(R.id.empate)
        val txtDerrotas = findViewById<TextView>(R.id.derrota)
        val resultado = findViewById<TextView>(R.id.resultado1)
        val imagenMaquina = findViewById<ImageView>(R.id.imagenMaquina)

        val btnPiedra = findViewById<ImageButton>(R.id.btnPiedra)
        val btnPapel = findViewById<ImageButton>(R.id.btnPapel)
        val btnTijera = findViewById<ImageButton>(R.id.btnTijera)
        val btnReiniciar = findViewById<Button>(R.id.btnReiniciar)

        fun jugar(eleccion: Int){
            val maquina = Random.nextInt(0,3)
            when(maquina){
                0 -> imagenMaquina.setImageResource(R.drawable.piedra)
                1 -> imagenMaquina.setImageResource(R.drawable.papel)
                2 -> imagenMaquina.setImageResource(R.drawable.tijera)
            }

            if(maquina == eleccion){
                empates++
                resultado.text = "¡Empate!"
            } else if ((eleccion == 0 && maquina == 2 ) || (eleccion == 1 && maquina == 0) || (eleccion == 2 && maquina == 1)){
                victorias++;
                resultado.text = "¡Victoria!"
            } else {
                derrotas++;
                resultado.text = "¡Derrota!"
            }
            txtVictorias.text = victorias.toString()
            txtEmpates.text = empates.toString()
            txtDerrotas.text = derrotas.toString()
        }

        btnPiedra.setOnClickListener {
            jugar(0)
        }
        btnPapel.setOnClickListener {
            jugar(1)
        }
        btnTijera.setOnClickListener {
            jugar(2)
        }

        fun reiniciar(){
            victorias = 0
            derrotas = 0
            empates = 0

            txtVictorias.text = victorias.toString()
            txtDerrotas.text = derrotas.toString()
            txtEmpates.text = empates.toString()

            resultado.text = "¡Elige tu jugada!"
            imagenMaquina.setImageResource(R.drawable.interrogacion)

        }

        btnReiniciar.setOnClickListener {
            reiniciar()
        }


    }
    var victorias = 0
    var empates = 0
    var derrotas = 0







}