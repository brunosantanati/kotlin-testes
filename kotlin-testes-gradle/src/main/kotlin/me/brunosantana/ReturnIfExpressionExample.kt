package me.brunosantana

fun main() {
    println(returnIfExpression(true))
    println(returnIfExpression(false))
}

fun returnIfExpression(condition: Boolean): String{
    return if(condition){
        "It's true"
    }else{
        "It's false"
    }
}