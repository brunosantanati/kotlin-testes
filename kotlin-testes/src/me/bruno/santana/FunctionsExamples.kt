package me.bruno.santana

class FunctionsExamples {

    fun square(number: Int) = number * number

    fun square2(number: Int): Int{
        return number * number
    }

}

fun FunctionsExamples.square3(number: Int) = number * number

fun main(){
    val obj = FunctionsExamples()
    println(obj.square(3))
    println(obj.square2(3))
    println(obj.square3(3))
}