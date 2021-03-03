package me.brunosantana.annotation2

data class Coverage(
    override val id: String,
    @ReplaceFieldContent(value = "coverageName")
    val name: String
): ReplaceableList