package com.redfox.tech.mytesteapplication.Fragment

import android.graphics.PorterDuff
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.redfox.tech.mytesteapplication.Model.getParametros
import com.redfox.tech.mytesteapplication.Model.getValues
import com.redfox.tech.mytesteapplication.Model.point1Parametros
import com.redfox.tech.mytesteapplication.Model.sendParametros
import com.redfox.tech.mytesteapplication.R
import com.redfox.tech.mytesteapplication.Task.ListaTask
import com.redfox.tech.mytesteapplication.Utilities.Util


class DetalhesFragment : Fragment(){


    private var Eixo: Int = 0
    private lateinit var Lista1: getParametros
    private lateinit var Lista2: getValues
    private lateinit var origem : TextView
    private lateinit var combustivel : TextView
    private lateinit var destino : TextView
    private lateinit var distancia : TextView
    private lateinit var duracao : TextView
    private lateinit var eixos : TextView
    private lateinit var total : TextView
    private lateinit var perigosa : TextView

    private lateinit var pedagio : TextView
    private lateinit var geral : TextView
    private lateinit var granel : TextView
    private lateinit var neogranel : TextView

    private lateinit var frigorificada : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_detalhes, container, false)

        origem = view.findViewById(R.id.origem)
        combustivel = view.findViewById(R.id.combustivel)
        destino = view.findViewById(R.id.destino)
        distancia = view.findViewById(R.id.distancia)
        duracao = view.findViewById(R.id.duracao)
        eixos = view.findViewById(R.id.eixos)
        total = view.findViewById(R.id.total)
        perigosa = view.findViewById(R.id.perigosa)
        pedagio = view.findViewById(R.id.pedagio)
        geral = view.findViewById(R.id.geral)
        granel = view.findViewById(R.id.granel)
        neogranel = view.findViewById(R.id.neogranel)
        frigorificada = view.findViewById(R.id.frigorificada)




      //  origem.setText(Lista1.)
        combustivel.text = Lista1.fuel_usage_unit+ " " + Lista1.fuel_usage
      //  destino = view.findViewById(R.id.destino)
        distancia.text = Lista1.distance.toString() + " " + Lista1.distance_unit
        duracao.text =Lista1.duration.toString() + " " +  Lista1.duration_unit
        eixos.text = Eixo.toString()
        total.text = Lista1.total_cost.toString()
        perigosa.text = "R$" + Lista2.perigosa
        pedagio.text = Lista1.toll_count.toString()  + "  +  Valor total dos pedagios" + Lista1.toll_cost_unit + " " +Lista1.toll_cost
        geral.text = "R$" + Lista2.geral
        granel.text = "R$" + Lista2.granel
        neogranel.text = "R$" + Lista2.neogranel
        frigorificada.text = "R$" + Lista2.frigorificada

        return  view
    }

    fun add(result1 : String, result2: String, eixo : Int){

        val serializer = Gson()
         Lista2 = serializer.fromJson(result2, getValues::class.java)
         Lista1 = serializer.fromJson(result1, getParametros::class.java)
        Eixo = eixo
    }

}
