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
import com.google.gson.JsonObject
import com.redfox.tech.mytesteapplication.Model.getParametros
import com.redfox.tech.mytesteapplication.Model.getValues
import com.redfox.tech.mytesteapplication.Model.point1Parametros
import com.redfox.tech.mytesteapplication.Model.sendParametros
import com.redfox.tech.mytesteapplication.R
import com.redfox.tech.mytesteapplication.Task.ListaTask
import com.redfox.tech.mytesteapplication.Utilities.Util


class MainFragment : Fragment(), AdapterView.OnItemSelectedListener{

    private lateinit var edt_inicial : EditText
    private lateinit var edt_final : EditText
    private lateinit var edt_consumo : EditText
    private lateinit var edt_valor : EditText

    private lateinit var spn_eixos : Spinner

    private lateinit var btn_enviar:Button


    var list_of_items = arrayOf(2, 3, 4, 5, 6, 7, 8)
    var eixos : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_main, container, false)


        edt_inicial = view.findViewById(R.id.edt_inicial)
        edt_final = view.findViewById(R.id.edt_final)
        edt_consumo = view.findViewById(R.id.edt_consumo)
        edt_valor = view.findViewById(R.id.edt_valor)
        spn_eixos = view.findViewById(R.id.spn_eixos)
        btn_enviar = view.findViewById(R.id.btn_proximo)


        spn_eixos.setOnItemSelectedListener(this)

        spn_eixos.background.setColorFilter(resources.getColor(R.color.colorBlueText), PorterDuff.Mode.SRC_ATOP)
        val aa = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, list_of_items)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spn_eixos!!.setAdapter(aa)
        btn_enviar.setOnClickListener {


            if (edt_inicial.text.toString().isNotEmpty() && edt_final.text.toString().isNotEmpty()
                && edt_consumo.text.toString().isNotEmpty() && edt_valor.text.toString().isNotEmpty() && eixos != 0){

                var geocoder = Geocoder(context)
                var enderecoinicial: List<Address> = geocoder.getFromLocationName(edt_inicial.text.toString(), 1)
                var enderecoFinal: List<Address> = geocoder.getFromLocationName(edt_final.text.toString(), 1)

                if (enderecoinicial.size > 0) {
                    if (enderecoFinal.size > 0) {


                        val list = ArrayList<Double>()
                        list.add( enderecoinicial[0].latitude)
                        list.add(enderecoinicial[0].longitude)

                        val list2 = ArrayList<Double>()
                        list2.add(enderecoFinal[0].latitude)
                        list2.add(enderecoFinal[0].longitude)

                        var point1Parametros = ArrayList<point1Parametros>()
                        var point2Parametros = point1Parametros(list)
                        var point3Parametros = point1Parametros(list2)
                        point1Parametros.add(point2Parametros)
                        point1Parametros.add(point3Parametros)


                        var param = sendParametros(point1Parametros, edt_valor.text.toString(), edt_consumo.text.toString(),eixos )

                        val gson = GsonBuilder().setPrettyPrinting().create()


                        val jsonInString = gson.toJson(param)

                        addData(jsonInString)
                    }else{
                        Toast.makeText(context!!, "Endereco Final invalido", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context!!, "Endereco Inicial invalido", Toast.LENGTH_SHORT).show()
                }



            }else{
                Toast.makeText(context!!, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }

        }


        return  view
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
        eixos = 0
    }

    override fun onItemSelected(arg0: AdapterView<*>?, arg1: View?, position: Int, id: Long) {
        eixos = list_of_items.get(position!!)
    }


    fun addData(parametros: String?) {
        object : ListaTask(parametros!!) {

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                if (result != null) {
                    try {
                        val serializer = Gson()
                     var Lista = serializer.fromJson(result, getParametros::class.java)
                        if (Lista != null) {

                            val parameters = JsonObject()


                            parameters.addProperty("axis", eixos)
                            parameters.addProperty("distance", Lista.distance)
                            parameters.addProperty("has_return_shipment", true)


                            addValues(parameters.toString(), result)

                        }

                    } catch (ex: Exception) {
                        Util.showMessage(
                            context!!,
                            "Aviso",
                            "Sem acesso à internet, tente novamente!"
                        )
                    }
                }
            }
        }.execute()
    }

    fun addValues(parametros: String?, result1: String) {
        object : ListaTask(parametros!!) {

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                if (result != null) {
                    try {
                        val serializer = Gson()
                        var Lista = serializer.fromJson(result, getValues::class.java)
                        if (Lista != null) {

                            var detalhe = DetalhesFragment()

                            detalhe.add(result1, result, eixos)
                            activity!!.supportFragmentManager.beginTransaction()
                                .replace(R.id.container, detalhe)
                                .addToBackStack("")
                                .commit()

                        }

                    } catch (ex: Exception) {
                        Util.showMessage(
                            context!!,
                            "Aviso",
                            "Sem acesso à internet, tente novamente!"
                        )
                    }
                }
            }
        }.execute()
    }
}
