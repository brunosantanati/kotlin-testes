package me.brunosantana

data class ValAndCopyExample(
    val field1: String,
    val field2: String,
    val field3: String,
)

fun main() {
    val obj1 = ValAndCopyExample(
        field1 = "campo 1",
        field2 = "campo 2",
        field3 = "campo 3"
    )

    val objCopy = obj1.copy(
        field1 = "field 1"
    )

    println(obj1)
    println(objCopy)
}