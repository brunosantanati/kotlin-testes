package me.brunosantana.annotation2

data class Offer (
    @ReplaceFieldContent(value = "name")
    val name: String,

    @ReplaceFieldContent(value = "other")
    val otherField: String,

    @ReplaceListContent(value = "coverages")
    val coverages: List<Coverage>,

    @ReplaceListContent(value = "benefits")
    val benefits: List<Benefit>
)