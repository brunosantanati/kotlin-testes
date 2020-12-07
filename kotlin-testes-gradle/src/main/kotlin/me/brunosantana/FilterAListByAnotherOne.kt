package me.brunosantana

data class BankSlip(
    val barCode: String
)

fun main() {
    val allBankSlips = listOf<BankSlip>(
        BankSlip("02145569874523654122220000147896520147852000"),
        BankSlip("02145569874523654122220000147896520147852001"),
        BankSlip("02145569874523654122220000147896520147852002"),
        BankSlip("02145569874523654122220000147896520147852003")
    )

    val depositBankSlips = listOf<BankSlip>(
        BankSlip("02145569874523654122220000147896520147852000"),
        BankSlip("02145569874523654122220000147896520147852001")
    )

    val filteredList = allBankSlips.filterByBarCode(depositBankSlips)
    filteredList.forEach{ println(it) }

    println("-----------------------------------")

    //the same logic/code but without using a separated function
    allBankSlips.filter {
        bankSlip -> depositBankSlips.any { it.barCode == bankSlip.barCode }
    }.forEach{ println(it) }
}

fun List<BankSlip>.filterByBarCode(depositBankSlips: List<BankSlip>) =
    filter { bankSlip -> depositBankSlips.any { it.barCode == bankSlip.barCode } }