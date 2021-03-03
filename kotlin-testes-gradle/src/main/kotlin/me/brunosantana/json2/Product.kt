package me.brunosantana.json2

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("productCode")
    val code: String,
    @SerializedName("productName")
    val name: String
)