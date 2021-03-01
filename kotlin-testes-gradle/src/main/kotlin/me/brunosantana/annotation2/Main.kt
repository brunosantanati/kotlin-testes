package me.brunosantana.annotation2

fun main() {
    val additionalInfo = mapOf<String, String>("name" to "Seguro Cartao BTG+", "other" to "Outro texto")
    val offer = Offer(name = "Seguro Cartao", otherField = "Qualquer coisa")
    println(offer)

    AdditionalInfoHandler().replaceFieldsContent(offer, additionalInfo)
    println(offer)
}