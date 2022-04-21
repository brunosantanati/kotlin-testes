package me.bruno.santana

import java.math.BigDecimal

data class ClassB(
    val amount: BigDecimal
)

data class ClassA(
    val listOfB: List<ClassB>
)

fun main() {
    val listOfB = listOf<ClassB>(
        ClassB(BigDecimal("15.0")),
        ClassB(BigDecimal("15.0")),
        ClassB(BigDecimal("10.15"))
    )

    val classA = ClassA(listOfB)

    //val amountTotal1 = classA.listOfB.map { it.amount }.sumOf { it } //in another laptop it works, I don't know why It's not working in this laptop

    //println(amountTotal1)

    val amountTotal2 = classA.listOfB.map { it.amount }.reduce { total, element -> total.plus(element) }

    println(amountTotal2)
}