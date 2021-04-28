package me.brunosantana

fun main() {
    val mapCommon = mapOf(
        "chave1" to "valor1",
        "chave2" to "valor2",
        "chave3" to "valor3"
    )

    val map1 = mapOf(
        "chave4" to "valor4",
        "chave5" to "valor5"
    )

    val map2 = mapOf(
        "chave10" to "valor10",
        "chave20" to "valor20"
    )

    val map3 = mapCommon + map1
    val map4 = mapCommon.plus(map2)

    println(map3)
    println(map4)
}