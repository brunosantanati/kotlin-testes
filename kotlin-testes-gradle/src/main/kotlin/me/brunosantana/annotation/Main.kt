package me.brunosantana.annotation

// Exemplo desse tutorial:
// https://www.baeldung.com/kotlin/annotations
// Link do repo com o código:
// https://github.com/Baeldung/kotlin-tutorials/tree/master/core-kotlin-modules/core-kotlin-annotations

fun main(args: Array<String>) {
    val item = Item(amount = 1.0f, name = "Bob")
    val item2 = Item(amount = -1.0f, name = "Bob")
    val item3 = Item(amount = 1.0f, name = "Thomas")

    val validator = Validator()

    println("Is instance valid? ${validator.isValid(item)}")
    println("Is instance valid? ${validator.isValid(item2)}")
    println("Is instance valid? ${validator.isValid(item3)}")
}
