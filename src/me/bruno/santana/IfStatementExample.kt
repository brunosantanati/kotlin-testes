package me.bruno.santana

fun main() {
    print("CPF? ")
    println(if(isCPF("78945612365")) "yes" else "no")
}

fun isCPF(document: String) = document.length <= 11