package me.brunosantana

import java.lang.Exception

fun main() {
    var names = try{
        AnyService().getNames()
    }catch (ex: Exception){
        println("Erro ${ex.message}")
        emptyList()
    }

    println(names)
}

class AnyService{
    fun getNames(): List<String>{
        //throw Exception("Simulating an exception") //uncomment to see the catch in action!
        return listOf("Nicodemus", "Hernandes", "Paulo", "Josemar")
    }
}