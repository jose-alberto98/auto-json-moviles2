package com.example.entrega_json

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
 lateinit var lista_autos : ArrayList<Auto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun comprobarConexion(){
        if (Network.hayRed(this)){
                solicitarJSON_object();
        }else{
            Toast.makeText(this,"Error de conexion",Toast.LENGTH_SHORT).show()
        }
    }





    fun solicitarJSON_object(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://autos-moviles2.000webhostapp.com/"

        val JsonObjectRequest = JsonObjectRequest(url, null,
            Response.Listener { response ->
                try {
                    val json : JSONObject
                    json =response
                    generar_array(json)

                }catch (e:JSONException){
                    Log.d("msg_error",e.localizedMessage)
                }
                Log.i("JSON_OBJECT", "response is $response")
            },
            Response.ErrorListener { error ->
                error.printStackTrace()

            }
        )
            queue.add(JsonObjectRequest)
    }

        fun generar_array(json :JSONObject){
            lista_autos = ArrayList()

            val json =json
            val  auto =json.getJSONArray("Autos")
            for (i in 0.. auto.length()-1){
                val id = auto.getJSONObject(i).getInt("id");
                val modelo = auto.getJSONObject(i).getInt("modelo")
                val marca = auto.getJSONObject(i).getString("marca")
                val color = auto.getJSONObject(i).getString("color")
                val cilindros = auto.getJSONObject(i).getInt("cilindros")
                val estado_auto = auto.getJSONObject(i).getString("estado_auto")
                lista_autos.add(Auto(id,modelo,marca,color,cilindros,estado_auto))
                Log.d("onCreate", lista_autos.count().toString())

                mandar_lista(lista_autos);
            }
    }


    fun btn_mostrar(view: View) {
        comprobarConexion()
    }


        fun mandar_lista(lista_auto : ArrayList<Auto>){
            val intent : Intent = Intent(applicationContext, Listar::class.java)
            intent.putParcelableArrayListExtra("lista_autos",lista_autos as java.util.ArrayList<out Parcelable>)
            startActivity(intent)

        }

}
