package me.brunosantana

fun main() {
    val matrix = arrayOf(
        intArrayOf(3, 7, 9),
        intArrayOf(0, 1, 0),
        intArrayOf(2, 4, 8)
    )

    println(matrix.contentDeepToString()) // [[3, 7, 9], [0, 1, 0], [2, 4, 8]]
}