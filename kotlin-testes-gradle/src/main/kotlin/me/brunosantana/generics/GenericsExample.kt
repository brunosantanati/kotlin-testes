package me.brunosantana.generics

interface DataLakeUpdater<T>{
    fun updateDataLake(data: String): List<T>
}

data class Credit(val value: String)

data class Account(val value: String)

class CreditManualUpdater: DataLakeUpdater<Credit>{
    override fun updateDataLake(data: String): List<Credit> {
        val list = mutableListOf<Credit>()
        for (i in 0..9){
            list.add(Credit("$data$i"))
        }
        return list
    }
}

class AccountManualUpdater: DataLakeUpdater<Account>{
    override fun updateDataLake(data: String): List<Account> {
        val list = mutableListOf<Account>()
        for (i in 0..9){
            list.add(Account("$data$i"))
        }
        return list
    }

}

fun main() {
    println(CreditManualUpdater().updateDataLake("credit"))
    println(AccountManualUpdater().updateDataLake("account"))
}