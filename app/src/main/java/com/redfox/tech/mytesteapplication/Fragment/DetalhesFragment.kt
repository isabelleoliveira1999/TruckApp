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
import com.redfox.tech.mytesteapplication.Model.point1Parametros
import com.redfox.tech.mytesteapplication.Model.sendParametros
import com.redfox.tech.mytesteapplication.R
import com.redfox.tech.mytesteapplication.Task.ListaTask
import com.redfox.tech.mytesteapplication.Utilities.Util


class DetalhesFragment : Fragment(){



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_main, container, false)



        return  view
    }

}
