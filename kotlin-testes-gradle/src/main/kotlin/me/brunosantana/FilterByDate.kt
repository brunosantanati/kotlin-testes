package me.brunosantana

import java.time.LocalDate
import java.time.Month

data class Transaction(
    val type: String,
    val date: LocalDate,
)

fun main() {
    val transactions = listOf(
        Transaction(type = "PIX", date = LocalDate.of(2021, Month.APRIL, 26)),
        Transaction(type = "DOC", date = LocalDate.of(2021, Month.APRIL, 25)),
        Transaction(type = "TED", date = LocalDate.of(2021, Month.JUNE, 26)),
        Transaction(type = "TRANSFER", date = LocalDate.of(2021, Month.JANUARY, 26)),
        Transaction(type = "TED", date = LocalDate.of(2021, Month.MARCH, 10)),
        Transaction(type = "DOC", date = LocalDate.of(2021, Month.MARCH, 28)),
        Transaction(type = "PIX", date = LocalDate.of(2021, Month.MARCH, 26)),
        Transaction(type = "TED", date = LocalDate.of(2021, Month.MAY, 20)),
        Transaction(type = "DOC", date = LocalDate.of(2021, Month.MAY, 28)),
        Transaction(type = "PIX", date = LocalDate.of(2021, Month.MAY, 26))
    )

    val oneMonthAgo = LocalDate.now().minusDays(30)
    val oneMonthLater = LocalDate.now().plusDays(30)

    println(oneMonthAgo)
    println(oneMonthLater)

    transactions.filter {
        it.date >= oneMonthAgo && it.date <= oneMonthLater
    }.forEach{
        println(it)
    }
}