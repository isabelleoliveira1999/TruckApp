package com.redfox.tech.mytesteapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList


data class pointsParametros(

                           @SerializedName("")
                           @Expose
                           val point1: List<Double>,
                           @SerializedName("")
                           @Expose
                           val point2: List<Double>

)