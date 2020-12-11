package com.example.entrega_json

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adaptador_custom(var context: Context, items : ArrayList<Auto>):
    RecyclerView.Adapter<Adaptador_custom.ViewHolder>() {

     var items:ArrayList<Auto>?
    init {
        this.items=items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador_custom.ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val vista = LayoutInflater.from(context).inflate(R.layout.template_autos,parent, false)
        var viewHolder =ViewHolder(vista)
        return  viewHolder
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: Adaptador_custom.ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val item =items?.get(position)

        holder?.id?.text=item?.id.toString()
        holder?.modelo?.text=item?.modelo.toString()
        holder?.marca?.text=item?.marca
        holder?.color?.text=item?.color
        holder?.cilindro?.text=item?.cilindro.toString()
        holder?.estado_auto?.text=item?.estado_auto

    }



    class ViewHolder (vista : View) : RecyclerView.ViewHolder(vista){
        var vista= vista

        var id : TextView? = null
        var modelo : TextView? = null
        var marca : TextView? = null
        var color : TextView? = null
        var cilindro : TextView? = null
        var estado_auto : TextView? = null


        init {
                id= vista.findViewById(R.id.mostrar_id)
            modelo= vista.findViewById(R.id.mostrar_modelo)
            marca= vista.findViewById(R.id.mostrar_marca)
            color= vista.findViewById(R.id.mostrar_color)
            cilindro= vista.findViewById(R.id.mostrar_cilindro)
            estado_auto= vista.findViewById(R.id.mostrar_estado)
        }
    }
}