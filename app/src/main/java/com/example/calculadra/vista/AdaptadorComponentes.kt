package com.example.calculadra.vista
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.ImageView
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadra.R
import com.example.calculadra.datos.RepositorioSingleton
import android.net.Uri


class AdaptadorComponentes : RecyclerView.Adapter<AdaptadorComponentes.CreadorItems>(){

    val lista = RepositorioSingleton.instance.listaComponentes

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nombre = itemView.findViewById<TextView>(R.id.txtNombreComponente)
        val categoria = itemView.findViewById<TextView>(R.id.txtCategoriaComponente)
        val precio = itemView.findViewById<TextView>(R.id.txtPrecioComponente)
        val imagen = itemView.findViewById<ImageView>(R.id.imgComponente)
        val valoracion = itemView.findViewById<RatingBar>(R.id.rbValoracion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreadorItems {
        val inflador = LayoutInflater.from(parent.context)
        val vista = inflador.inflate(R.layout.item_componente, parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(holder: CreadorItems, position: Int) {
        val componente = lista.buscar(position)

        holder.nombre.text = componente.nombre
        holder.categoria.text = componente.categoria
        holder.precio.text = "${componente.precio} €"
        if (componente.imagenUri != null){
            holder.imagen.setImageURI(Uri.parse(componente.imagenUri))
        } else {
            holder.imagen.setImageResource(componente.imagen)
        }
        holder.valoracion.rating = componente.valoracion



    }

    override fun getItemCount(): Int {
        return lista.longitud()
    }


}