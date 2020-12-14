package me.brunosantana

//doc: https://kotlinlang.org/docs/reference/object-declarations.html

interface Animal{
    fun eat()
}

fun main() {
    val horse = object: Animal{
        override fun eat() {
            println("Horse eating...")
        }
    }

    val cow = object: Animal{
        override fun eat() {
            println("Cow eating... muuuu")
        }
    }

    horse.eat()
    cow.eat()
}

