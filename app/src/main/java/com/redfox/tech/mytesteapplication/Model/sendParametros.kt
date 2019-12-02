package com.redfox.tech.mytesteapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList


data class sendParametros(

                           @SerializedName("places")
                           @Expose
                           val places: List<point1Parametros?>,
                           @SerializedName("fuel_price")
                           @Expose
                           val fuel_price: String?,
                           @SerializedName("fuel_consumption")
                           @Expose
                           val fuel_consumption: String?,
                           @SerializedName("axis")
                           @Expose
                           val eixos: Int?

)