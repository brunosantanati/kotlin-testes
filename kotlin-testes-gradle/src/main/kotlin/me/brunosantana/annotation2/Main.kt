package me.brunosantana.annotation2

fun main() {
    val additionalInfo = mapOf("name" to "Seguro Cartao BTG+", "other" to "Outro texto")
    val additionalInfoForLists = mapOf(
        "coverageName" to mapOf("1" to "Coverage 1", "2" to "Coverage 2"),
        "benefitName" to mapOf("1" to "Benefit 1", "2" to "Benefit 2")
    )

    val offer = Offer(
        name = "Seguro Cartao",
        otherField = "Qualquer coisa",
        coverages = listOf(
            Coverage(id = "1", name = "Cobertura contra roubo"),
            Coverage(id = "2", name = "Cobertura contra saque sob coacao")
        ),
        benefits = listOf(
            Benefit(id = "1", name = "Chaveiro 24h"),
            Benefit(id = "2", name = "Resgate Bike")
        )
    )
    println(offer)

    AdditionalInfoHandler().replaceFieldsContent(offer, additionalInfo, additionalInfoForLists)
    println(offer)
}