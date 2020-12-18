package me.brunosantana

import org.slf4j.LoggerFactory

data class BankSlip2(
    val barCode: String
)

class LoggingWithSLF4J {

    private val logger = LoggerFactory.getLogger(LoggingWithSLF4J::class.java)

    fun logBankSlips(bankSlips: List<BankSlip2>){
        println("teste")
        logger.info("Log de teste")
        logger.info("Boletos a serem removidos: ${bankSlips.map { it.barCode }}")
    }

}

fun main() {
    LoggingWithSLF4J().logBankSlips(
        listOf<BankSlip2>(
            BankSlip2("02145569874523654122220000147896520147852000"),
            BankSlip2("02145569874523654122220000147896520147852001"),
            BankSlip2("02145569874523654122220000147896520147852002")
        )
    )
}