package me.brunosantana

fun doSomething(){
    println("doing something")
    //throw RuntimeException("making unit test fail")
}

fun doSomethingThatThrowsException(){
    println("doing something")
    throw RuntimeException("expected exception")
}