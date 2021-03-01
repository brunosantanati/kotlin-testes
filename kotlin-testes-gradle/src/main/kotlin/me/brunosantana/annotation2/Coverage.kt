package me.brunosantana.annotation2

data class Coverage(
    val id: String,
    @ReplaceContent(value = "coverageName")
    val name: String
)