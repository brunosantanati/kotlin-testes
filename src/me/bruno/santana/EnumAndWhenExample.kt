package me.bruno.santana

enum class Direction {
    NORTH, SOUTH, WEST, EAST, NONE
}

class EnumAndWhenExample {

    fun chooseDirection(direction: Direction){
        when(direction){
            Direction.NORTH -> println("North")
            Direction.SOUTH -> println("South")
            Direction.WEST -> println("West")
            Direction.EAST -> println("East")
            else -> {
                println("Find nothing")
            }
        }
    }

}

fun main(){
    EnumAndWhenExample().chooseDirection(Direction.NORTH)
    EnumAndWhenExample().chooseDirection(Direction.NONE)
}