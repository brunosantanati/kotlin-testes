package me.brunosantana.json2

import com.google.gson.annotations.SerializedName

data class OfferAllInformation (
    @SerializedName("product")
    val product: Product,
    @SerializedName("offer")
    val offer: Offer
)