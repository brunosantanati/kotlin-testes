package me.brunosantana

fun main() {
    val listDC = listOf("Batman", "Mulher Maravilha", "Aquaman", "Superman", "Capitão Marvel")
    println(listDC)

    val emptyList = emptyList<String>()
    println("emptyList: $emptyList")

    val listDC2 = (listDC subtract emptyList).toList()
    println(listDC2)
}