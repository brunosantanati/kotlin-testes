package me.brunosantana

// https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java

// https://kotlinexpertise.com/kotlin-generics-and-variance-vs-java/
// Array<in String> corresponds to Java’s Array<? super String> and
// Array<out String> corresponds to Java’s Array<? extends Object>

fun main() {
    val offersComplete = listOf(
        OfferComplete(code = 1, name = "Z", description = "Z description"),
        OfferComplete(code = 2, name = "W", description = "W description")
    )
    iterateOverList(offersComplete)

    val offersShort = listOf(
        OfferShort(code = 1, name = "A"),
        OfferShort(code = 2, name = "B")
    )
    iterateOverList(offersShort)

    println("#################")

    val product1 = Product(offersComplete)
    println(product1)
    val product2 = Product(offersShort)
    println(product2)
}

fun iterateOverList(offers: List<out Offer>){
    for(offer in offers){
        println(offer)
    }
}

data class Product(
    val offers: List<out Offer>
)

abstract class Offer

data class OfferComplete(
    val code: Long,
    val name: String,
    val description: String,
): Offer()

data class OfferShort(
    val code: Long,
    val name: String,
): Offer()