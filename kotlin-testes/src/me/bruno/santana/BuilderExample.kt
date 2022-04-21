package me.bruno.santana

import java.math.BigDecimal

data class Transaction(
    val transactionId: String,
    val amount: BigDecimal
)

class TransactionBuilder private constructor(){
    var transactionId: String? = null
        private set
    var amount: BigDecimal? = null
        private set

    companion object{
        fun newBuilder() = TransactionBuilder()
    }

    fun transactionId(transactionId: String) = apply { this.transactionId = transactionId }
    fun amount(amount: BigDecimal) = apply { this.amount = amount }

    fun build() = Transaction(
        transactionId = transactionId ?: "111",
        amount = amount ?: BigDecimal("1000.10")
    )
}

fun main() {
    println(TransactionBuilder.newBuilder().build())
    println(TransactionBuilder.newBuilder().transactionId("1").amount(BigDecimal("5.55")).build())
    println(TransactionBuilder.newBuilder().transactionId("1").build())
}