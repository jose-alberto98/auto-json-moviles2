package com.example.entrega_json

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Listar : AppCompatActivity() {
   lateinit var lista_autos :ArrayList<Auto>

    var lista : RecyclerView?=null
    var layoutManager: RecyclerView.LayoutManager?=null
    var adaptador: Adaptador_custom?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        lista_autos = ArrayList()
        var intent: Intent = intent
        lista_autos = intent.getParcelableArrayListExtra("lista_autos")


        lista = findViewById(R.id.lista_autos)
        lista?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        adaptador = Adaptador_custom(this, lista_autos!!)
        lista?.layoutManager = layoutManager
        lista?.adapter = adaptador








    }

    }