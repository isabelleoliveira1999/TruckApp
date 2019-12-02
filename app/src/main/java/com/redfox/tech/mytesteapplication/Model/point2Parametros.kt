package com.redfox.tech.mytesteapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList


data class point2Parametros(

                           @SerializedName("point")
                           @Expose
                           val point: List<Double>

)