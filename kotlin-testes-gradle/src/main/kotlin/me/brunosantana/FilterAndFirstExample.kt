package me.brunosantana

fun main() {
    //filter with first ok
    val list = mutableListOf("Diciane", "te", "amo")
    val first = list.filter { item -> item == "Diciane" }.first()
    println(first)

    //filter returns empty list
    val emptyAfterFilter = list.filter { item -> item.length == 1 }
    println(emptyAfterFilter)

    //do not call first at empty list
    val emptyList = mutableListOf<String>()
    val emptyListFiltered = emptyList.filter { item -> item == "Diciane" }
    println(emptyListFiltered)
    //println(emptyListFiltered.first()) //java.util.NoSuchElementException: List is empty.
    if (emptyListFiltered.isNotEmpty()){ //verificar antes
        println("entrou")
        println(emptyListFiltered.first())
    }
}