package me.brunosantana.json2

data class Offer (
    val offerCode: String,
    val offerName: String,
    val coverages: List<Coverage>
)