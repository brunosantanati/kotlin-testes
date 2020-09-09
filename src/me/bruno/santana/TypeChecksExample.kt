package me.bruno.santana

fun main(){

    val obj = "Teste"

    if (obj is String) {
        println(obj.length)
    }

    if (obj !is String) { // same as !(obj is String)
        println("Not a String")
    }
    else {
        println(obj.length)
    }
}