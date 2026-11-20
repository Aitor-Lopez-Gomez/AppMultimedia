package com.example.calculadra

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val calc = CalculadoraKT()
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imgIconoJuego)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        resultado = findViewById(R.id.textView3)

        val listaBotones = listOf<Button>(
            findViewById(R.id.ac),
            findViewById(R.id.del),
            findViewById(R.id.porcentaje),
            findViewById(R.id.dividir),
            findViewById(R.id.multiplicar),
            findViewById(R.id.sumar),
            findViewById(R.id.restar),
            findViewById(R.id.igual),
            findViewById(R.id.but1),
            findViewById(R.id.but2),
            findViewById(R.id.but3),
            findViewById(R.id.but4),
            findViewById(R.id.but5),
            findViewById(R.id.but6),
            findViewById(R.id.but7),
            findViewById(R.id.but8),
            findViewById(R.id.but9),
            findViewById(R.id.but0),
            findViewById(R.id.buts),
            findViewById(R.id.coma)
        )

        for (i in listaBotones) {
            i.setOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {

            R.id.but1 -> {
                calc.meterNumero(1)
            }

            R.id.but2 -> {
                calc.meterNumero(2)
            }

            R.id.but3 -> {
                calc.meterNumero(3)
            }

            R.id.but4 -> {
                calc.meterNumero(4)
            }

            R.id.but5 -> {
                calc.meterNumero(5)
            }

            R.id.but6 -> {
                calc.meterNumero(6)
            }

            R.id.but7 -> {
                calc.meterNumero(7)
            }

            R.id.but8 -> {
                calc.meterNumero(8)
            }

            R.id.but9 -> {
                calc.meterNumero(9)
            }

            R.id.but0 -> {
                calc.meterNumero(0)
            }

            R.id.sumar -> {
                calc.operacion('+')
            }

            R.id.restar -> {
                calc.operacion('-')
            }

            R.id.multiplicar -> {
                calc.operacion('*')
            }

            R.id.dividir -> {
                calc.operacion('/')
            }

            R.id.igual -> {
                calc.igual()
            }

            R.id.ac -> {
                calc.clear()
            }

            R.id.coma -> {
                calc.meterComa()
            }
            R.id.del -> {
                calc.borrarUltimo()
            }
            R.id.porcentaje -> {
                calc.porcentaje()
            }
            R.id.buts -> {
                calc.cambioSigno()
            }
        }

        if (calc.num2.isEmpty()) {
            resultado.text = "0"
        } else {
            resultado.text = calc.num2
        }
    }
}