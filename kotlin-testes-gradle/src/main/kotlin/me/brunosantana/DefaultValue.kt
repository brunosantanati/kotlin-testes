package me.brunosantana

data class Person(
    val name: String = "Bruno"
)

fun main() {
    println(Person("Joao"))
    println(Person(""))
    println(Person())
}