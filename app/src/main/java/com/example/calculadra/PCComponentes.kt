package com.example.calculadra
import androidx.appcompat.app.AlertDialog
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
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.calculadra.datos.RepositorioSingleton
import com.google.android.material.appbar.MaterialToolbar


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
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarComponentes)
        val recycler = findViewById<RecyclerView>(R.id.rvComponentes)


        adaptador = AdaptadorComponentes()

        recycler.adapter = adaptador
        recycler.layoutManager = LinearLayoutManager(this)



        btnVolver.setOnClickListener {
            finish()
        }
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menuAnadir -> {
                    val intent = Intent(this, AnadirComponenteActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menuEliminar -> {
                    val position = adaptador.posicionSeleccionada
                    if (position == RecyclerView.NO_POSITION){
                        Toast.makeText(this,"Selecciona un componente", Toast.LENGTH_SHORT).show()
                    } else {
                        AlertDialog.Builder(this)
                            .setTitle("Eliminar Componente")
                            .setMessage("¿Seguro que quieres eliminar este componente?")
                            .setPositiveButton("Eliminar") {_,_ ->
                                RepositorioSingleton.instance.listaComponentes.borrar(position)
                                adaptador.limpiarSeleccion()
                            }
                            .setNegativeButton("Cancelar", null)
                            .show()

                    }
                    true
                }
                else -> false
            }
        }

    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }


}