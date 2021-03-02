package me.brunosantana.annotation2

data class Benefit (
    val id: String,
    @ReplaceFieldContent(value = "benefitName")
    val name: String
)