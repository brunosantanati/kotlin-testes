package me.brunosantana

// Example based on https://mkyong.com/kotlin/kotlin-how-to-loop-a-map/

fun main(args: Array<String>) {

    val items = HashMap<String, Int>()
    items["A"] = 10
    items["B"] = 20
    items["C"] = 30

    println("-- Example 1 -- \n $items");

    //for loop
    println("\n-- Example 1.1 -- ");
    for ((k, v) in items) {
        println("$k = $v")
    }

    //for loop + lambdas filter
    println("\n-- Example 1.2 --");
    for ((k, v) in items) {
        if (k == "C")
            println("Find by key 'C' : $k = $v")
    }

    //Actually, you can filter key like this
    println("\n-- Example 1.3 -- ");
    val filteredItems = items.filterKeys { it == "A" || it == "C" }
    println("Find by key == A or C : $filteredItems")

    //Or filter value like this
    println("\n-- Example 1.4 --");
    val filterItems2 = items.filterValues { it <= 20 }
    println("Find by value <=20 : $filterItems2")

    //Or just filters
    println("\n-- Example 1.5 --");
    val filterItems3 = items.filter { it.key == "B" && it.value == 20 }
    println("Find by key == 'B' and value == 20 : $filterItems3")

}