package me.brunosantana.annotation2

data class Benefit (
    val id: String,
    @ReplaceContent(value = "benefitName")
    val name: String
)