package me.brunosantana.combine

import com.google.gson.annotations.SerializedName

data class OfferAllInformationExtra (
    @SerializedName("productExtra")
    val productExtra: ProductExtra,
    @SerializedName("offerExtra")
    val offerExtra: OfferExtra
)

data class OfferExtra (
    @SerializedName("offerCodeExtra")
    val codeExtra: String,
    @SerializedName("offerNameExtra")
    val nameExtra: String,
    @SerializedName("offerDescriptionExtra")
    val descriptionExtra: String,
    @SerializedName("coveragesExtra")
    val coveragesExtra: List<CoverageExtra>
)

data class CoverageExtra (
    @SerializedName("coverageCodeExtra")
    val codeExtra: String,
    @SerializedName("coverageNameExtra")
    val nameExtra: String,
    @SerializedName("coverageDescriptionExtra")
    val descriptionExtra: String
)

data class ProductExtra (
    @SerializedName("productCodeExtra")
    val codeExtra: String,
    @SerializedName("productNameExtra")
    val nameExtra: String,
    @SerializedName("productDescriptionExtra")
    val descriptionExtra: String
)