package me.brunosantana.generics

// Some examples from:
// https://www.raywenderlich.com/3634394-kotlin-generics-tutorial-getting-started
// All code examples here: https://github.com/brunosantanati/kotlin-generics-materials

open class Animal(open val id: Int, open val name: String)

data class Dog(override val id: Int, override val name: String, val furColor: FurColor) : Animal(id, name)

data class Cat(override val id: Int, override val name: String, val eyesColor: EyesColor) : Animal(id, name)

enum class FurColor {
    WHITE, BLACK, BROWN, SPOTTED, PATCHED
}

enum class EyesColor {
    BLUE, GREEN, BROWN, YELLOWISH
}

//data class Cage<T>(var animal: T, val size: Double)
data class Cage<T : Animal>(var animal: T, val size: Double)

fun main() {
    val dog: Dog = Dog(id = 1, name = "Stu", furColor = FurColor.PATCHED)
    val cat: Cat = Cat(id = 4, name = "Peter", eyesColor = EyesColor.GREEN)
    val cageDog: Cage<Dog> = Cage(animal = dog, size = 6.0)
    val cageCat: Cage<Cat> = Cage(animal = cat, size = 3.0)

    println(cageDog)
    println(cageCat)
}
