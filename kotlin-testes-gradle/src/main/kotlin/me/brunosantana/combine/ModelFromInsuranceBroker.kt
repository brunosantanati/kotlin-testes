package me.brunosantana.combine

import com.google.gson.annotations.SerializedName

data class OfferAllInformation (
    @SerializedName("product")
    val product: Product,
    @SerializedName("offer")
    val offer: Offer
)

data class Offer (
    @SerializedName("offerCode")
    val code: String,
    @SerializedName("offerName")
    val name: String,
    @SerializedName("coverages")
    val coverages: List<Coverage>
)

data class Coverage (
    @SerializedName("coverageCode")
    val code: String,
    @SerializedName("coverageName")
    val name: String
)

data class Product (
    @SerializedName("productCode")
    val code: String,
    @SerializedName("productName")
    val name: String
)