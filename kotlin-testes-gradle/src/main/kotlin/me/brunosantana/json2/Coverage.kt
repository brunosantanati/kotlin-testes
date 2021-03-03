package me.brunosantana.json2

import com.google.gson.annotations.SerializedName

data class Coverage (
    @SerializedName("coverageCode")
    val code: String,
    @SerializedName("coverageName")
    val name: String
)