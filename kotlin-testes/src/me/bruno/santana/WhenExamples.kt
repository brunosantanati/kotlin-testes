package me.bruno.santana

fun main(){

    val x = 1
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> { // Note the block
            println("x is neither 1 nor 2")
        }
    }

    val name = "Batman"
    when{
        isMyName(name) -> println("It's me")
        isASuperHeroe(name) -> println("It's a super heroe")
        else -> println("It's another guy")
    }
}

fun isMyName(name: String) = name == "Bruno"
fun isASuperHeroe(name: String) = when(name){
    "Batman" -> true
    "Super Homem" -> true
    "Hulk" -> true
    else -> false
}