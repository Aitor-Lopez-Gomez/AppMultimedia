package com.example.calculadra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculadra.vista.AdaptadorComponentes
import android.net.Uri
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts


class PCComponentes : AppCompatActivity() {
    private lateinit var adaptador : AdaptadorComponentes

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pccomponentes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imgIconoJuego)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnVolver = findViewById<ImageButton>(R.id.btnVolver)
        val btnAnadir = findViewById<Button>(R.id.btnAnadirComponente)
        val recycler = findViewById<RecyclerView>(R.id.rvComponentes)


        adaptador = AdaptadorComponentes()

        recycler.adapter = adaptador
        recycler.layoutManager = LinearLayoutManager(this)



        btnVolver.setOnClickListener {
            finish()
        }
        btnAnadir.setOnClickListener {
            val intent = Intent(this, AnadirComponenteActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }


}