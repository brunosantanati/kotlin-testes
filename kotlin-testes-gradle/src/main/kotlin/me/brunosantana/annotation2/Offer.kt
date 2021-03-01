package me.brunosantana.annotation2

data class Offer (
    @ReplaceContent(value = "name")
    val name: String,

    @ReplaceContent(value = "other")
    val otherField: String,

    @ReplaceContentForList(value = "coverages")
    val coverages: List<Coverage>
)