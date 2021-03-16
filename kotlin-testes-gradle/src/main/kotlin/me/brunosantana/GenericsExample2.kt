package me.brunosantana

// https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java

// https://kotlinexpertise.com/kotlin-generics-and-variance-vs-java/
// Array<in String> corresponds to Java’s Array<? super String> and
// Array<out String> corresponds to Java’s Array<? extends Object>

fun main() {
    val offersComplete = listOf(
        OfferComplete2(code = 1, name = "Z", description = "Z description"),
        OfferComplete2(code = 2, name = "W", description = "W description")
    )
    iterateOverList2(offersComplete)

    val offersShort = listOf(
        OfferShort2(code = 1, name = "A"),
        OfferShort2(code = 2, name = "B")
    )
    iterateOverList2(offersShort)

    println("#################")

    val product1 = Product2(offersComplete)
    println(product1)
    val product2 = Product2(offersShort)
    println(product2)
}

fun iterateOverList2(offers: List<Offer2>){
    for(offer in offers){
        println(offer)
    }
}

data class Product2(
    val offers: List<Offer2>
)

abstract class Offer2(
    val code: Long,
    val name: String,
)

class OfferComplete2(
    code: Long,
    name: String,
    val description: String,
): Offer2(code, name){
    override fun toString(): String {
        return "OfferComplete(code=$code, name='$name', description='$description')"
    }
}

class OfferShort2(
    code: Long,
    name: String,
): Offer2(code, name){
    override fun toString(): String {
        return "OfferShort(code=$code, name='$name')"
    }
}