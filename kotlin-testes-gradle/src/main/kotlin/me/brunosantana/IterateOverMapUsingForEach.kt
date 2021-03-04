package me.brunosantana

// Example based on https://mkyong.com/kotlin/kotlin-how-to-loop-a-map/

fun main(args: Array<String>) {

    val items2 = hashMapOf("A" to 10, "B" to 20, "C" to 30)
    items2["D"] = 40

    // foreach example
    println("\n-- Example 2.1 --");
    items2.forEach { k, v ->
        println("$k = $v")
    }

    // foreach + filter
    println("\n-- Example 2.1 --");
    items2.forEach { k, v ->
        if (v == 10) {
            println("$k = $v")
        }
    }

    // using the special 'it' like this
    println("\n-- Example 2.2 --");
    items2.forEach { println("key : ${it.key}, value : ${it.value}") }

}