package me.brunosantana

/*

https://kotlinlang.org/docs/reference/scope-functions.html

Function	Object reference	Return value	Is extension function
let	        it	                Lambda result	Yes
run	        this	            Lambda result	Yes
run	        -	                Lambda result	No: called without the context object
with	    this	            Lambda result	No: takes the context object as an argument.
apply	    this	            Context object	Yes
also	    it	                Context object	Yes
 */

class ScopeFunctions {
    fun letExample(param: String){
        val number = param.let {
            if (it == "two")
                2
            else
                1
        }.also {
            println("log -> ${it}")
        }

        println(number)
    }
}

fun main() {
    ScopeFunctions().letExample("two")
    ScopeFunctions().letExample("one")
}