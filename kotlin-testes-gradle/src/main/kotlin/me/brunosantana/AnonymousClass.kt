package me.brunosantana

//doc: https://kotlinlang.org/docs/reference/object-declarations.html
//https://stackoverflow.com/questions/43737785/kotlin-interface-does-not-have-constructors
//https://kotlinlang.org/docs/reference/whatsnew14.html#sam-conversions-for-kotlin-interfaces

// From now on, you can use SAM conversions for Kotlin interfaces as well.
// To do so, mark a Kotlin interface explicitly as functional with the fun modifier.
fun interface Animal{
    fun eat()
}

fun interface Flyable{
    fun fly(flyLongDistances: Boolean)
}

fun main() {

    //anonymous classes
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

    //lambda (using functional interface with method without parameter)
    val dog = Animal { println("Dog eating...") }

    horse.eat()
    cow.eat()
    dog.eat()

    //#####################################################

    //anonymous class
    val dove = object: Flyable{
        override fun fly(flyLongDistances: Boolean) {
            println("I'm flying... fly long distances? $flyLongDistances")
        }

    }

    //lambda (using functional interface with method with parameter)
    val dove2 = Flyable { flyLongDistances -> println("I'm flying... fly long distances? $flyLongDistances") }

    dove.fly(true)
    dove2.fly(true)

}

