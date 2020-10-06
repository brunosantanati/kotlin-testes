package me.bruno.santana

//doc: https://kotlinlang.org/docs/tutorials/kotlin-for-py/inheritance.html

interface Vehicle{
    fun startTheEngine()
}
open class MotorVehicle(val maxSpeed: Double, val horsepowers: Int)

class Car(
        val seatCount: Int,
        maxSpeed: Double
) : Vehicle, MotorVehicle(maxSpeed, 100) {

    override fun startTheEngine() {
        println("Starting the engine...")
    }

    override fun toString(): String {
        return "Car[seatCount=$seatCount, maxSpeed=$maxSpeed, horsepowers=$horsepowers]"
    }
}

fun main() {
    val car = Car(seatCount = 5, maxSpeed = 170.0)
    println(car)
    car.startTheEngine()
}