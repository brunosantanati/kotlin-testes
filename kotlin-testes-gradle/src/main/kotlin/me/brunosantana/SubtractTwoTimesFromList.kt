package me.brunosantana

fun main() {
    val listDC = listOf("Batman", "Mulher Maravilha", "Aquaman", "Superman", "Capitão Marvel")
    println(listDC)

    val toBeRemoved = listOf("Aquaman", "Mulher Maravilha")
    println("toBeRemoved: $toBeRemoved")

    val listDC2 = (listDC subtract toBeRemoved).toList()
    println(listDC2)

    val toBeRemoved2 = listDC2.filter { it != "Batman" }
    println("toBeRemoved2: $toBeRemoved2")

    val listDC3 = (listDC2 subtract toBeRemoved2).toList()
    println(listDC3)
}