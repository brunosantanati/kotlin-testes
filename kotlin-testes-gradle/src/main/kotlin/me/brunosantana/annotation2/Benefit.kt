package me.brunosantana.annotation2

data class Benefit (
    override val id: String,
    @ReplaceFieldContent(value = "benefitName")
    val name: String
): ReplaceableList