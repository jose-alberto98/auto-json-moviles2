package com.example.entrega_json

import android.content.Context
import android.net.ConnectivityManager
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity

class Network {
    companion object{
        fun hayRed(activity: AppCompatActivity):Boolean{
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
            val networkInfo =connectivityManager.activeNetworkInfo
            return  networkInfo != null && networkInfo.isConnected
        }
    }
}

class Auto(val id : Int, val  modelo : Int, val marca: String, val color : String, val cilindro: Int, val estado_auto: String ):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {

    }




    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        parcel.writeInt(id)
        parcel.writeInt(modelo)
        parcel.writeString(marca)
        parcel.writeString(color)
        parcel.writeInt(cilindro)
        parcel.writeString(estado_auto)


    }

    override fun describeContents(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
return  0
    }








    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Auto>
        {
            override fun createFromParcel(parcel: Parcel): Auto {
                return Auto(parcel)
            }

            override fun newArray(size: Int): Array<Auto?> {
                return arrayOfNulls(size)
            }
        }
    }

}