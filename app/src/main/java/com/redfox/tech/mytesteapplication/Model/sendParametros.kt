package com.redfox.tech.mytesteapplication.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*


data class sendParameters(
                           @SerializedName("id")
                           @Expose
                           val id: Int?,
                           @SerializedName("type")
                           @Expose
                           val type: String?
)