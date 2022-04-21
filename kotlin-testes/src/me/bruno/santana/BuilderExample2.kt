package me.bruno.santana

data class Dog(
    val name: String,
    val breed: String,
    val age: Int
)

fun buildDog(
    name: String = "Fofuxo",
    breed: String = "poodle",
    age: Int = 17
) = Dog(
    name = name,
    breed = breed,
    age = age
)

fun main() {
    println(buildDog())
    println(buildDog("Rin Tin Tin", "pastor alemao", 10))
    println(buildDog("Lassie", "rough collie"))
}