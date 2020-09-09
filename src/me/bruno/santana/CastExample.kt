package me.bruno.santana

open class Parent{
    fun parentAction(){
        println("parent")
    }
}

class Child : Parent() {
    fun childAction(){
        println("child")
    }
}

fun main(){

    val z: Parent = Child()
    z.parentAction()

    val a: Child = z as Child //cast
    a.parentAction()
    a.childAction()

    //"Safe" (nullable) cast operator
    val y = 1
    val k: String? = y as? String
    println(k)
    //"Unsafe" cast operator
    val x: String = y as String //java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
}