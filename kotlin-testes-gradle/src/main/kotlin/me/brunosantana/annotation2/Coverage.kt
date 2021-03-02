package me.brunosantana.annotation2

data class Coverage(
    val id: String,
    @ReplaceFieldContent(value = "coverageName")
    val name: String
)