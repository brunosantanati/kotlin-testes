package me.brunosantana

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun main() {
    //val value = "{ \"id\": \"v2\" }"
    val value = "{ \"id\": \"v2\", \"n\": 10, \"n2\": 20.0, \"b\": true, \"blocked_ids\": [\"1234\", \"5678\"], \"actions\": [\"BLOCK\"] }"

    val type = object: TypeToken<Map<String, *>>() {}.type
    val jsonMap: Map<String, *> = Gson().fromJson(value, type) as Map<String, *>

    println(jsonMap)
    jsonMap.forEach { (k, v) ->
        println("$k = $v")
        println("${v!!::class.qualifiedName}")
    }

    println("\nVALUES")
    val id = jsonMap["id"] as String
    println(id)
    val n = jsonMap["n"] as Double
    println(n.toInt())
    val n2 = jsonMap["n2"] as Double
    println(n2)
    val b = jsonMap["b"] as Boolean
    println(b)
    val blockedIds = jsonMap["blocked_ids"] as ArrayList<String>
    println(blockedIds)
    val actions = jsonMap["actions"] as ArrayList<String>
    println(actions)

    println("\nVALUES 2")
    val nn = getValueFromMap(jsonMap, "n", "1000000")
    println(nn)

    val itDoesNotExist = getValueFromMap(jsonMap, "it_does_not_exist", "1000000")
    println(itDoesNotExist)
}

fun getValueFromMap(jsonMap: Map<String, *>?, key: String, defaultValue: String): String{
    if(jsonMap != null){
        try {
            val valueFromMap = jsonMap[key] as Double
            return valueFromMap.toLong().toString()
        }catch (e: Exception){
            print(e.message)
            println("Problem with the key: $key")
        }
    }
    return defaultValue
}