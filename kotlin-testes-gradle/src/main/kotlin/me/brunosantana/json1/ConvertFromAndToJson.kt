package me.brunosantana.json1

import com.google.gson.Gson

// Example based on this tutorial: https://www.baeldung.com/kotlin/json-convert-data-class
// Source code: https://github.com/Baeldung/kotlin-tutorials/blob/master/kotlin-libraries-2/src/test/kotlin/com/baeldung/gson/GsonUnitTest.kt

fun main() {
    var gson = Gson()

    // Convert obj to json
    var json = gson.toJson(TestModel(1, "Test"))
    println(json)

    // Convert json to obj
    var jsonString = """{"id":1,"description":"Test"}"""; //without escape
    //var jsonString = "{\"id\":1,\"description\":\"Test\"}"; //with escape
    var testModel = gson.fromJson(jsonString, TestModel::class.java)
    println(testModel)
}

data class TestModel(
    val id: Int,
    val description: String
)