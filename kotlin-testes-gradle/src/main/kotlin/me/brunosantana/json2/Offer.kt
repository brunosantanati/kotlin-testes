package me.brunosantana.json2

import com.google.gson.annotations.SerializedName

data class Offer (
    @SerializedName("offerCode")
    val code: String,
    @SerializedName("offerName")
    val name: String,
    @SerializedName("coverages")
    val coverages: List<Coverage>
)