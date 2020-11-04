package me.bruno.santana

fun main() {

    val superHero = "Hulk"
    val mapa = mapOf(
            "Avengers" to superHero
    )

    println(mapa)

    val marvel = "Marvel"
    val dc = "DC"
    val mapa2 = mapOf<String, String>(
            "Hulk" to marvel,
            "Thor" to marvel,
            "Homem de Ferro" to marvel,
            "Batman" to dc,
            "Superman" to dc,
            "Mulher Maravilha" to dc,
            "Wanted" to "Millarworld"
    )

    println(mapa2)

    mapa2.forEach {
        println("key: ${it.key} value: ${it.value}")
    }
}