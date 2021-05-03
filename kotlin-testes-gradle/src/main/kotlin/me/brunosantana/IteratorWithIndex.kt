package me.brunosantana

fun main() {
    val list = listOf("Thor", "Hulk", "Spider-man")
    val iterator = list.iterator()
    for((index, item) in iterator.withIndex()){
        println("$index $item")
    }

    println()

    val iterator2 = list.iterator()
    for((index, item) in iterator2.withIndex()){
        println("${index + 1} $item")
    }
}