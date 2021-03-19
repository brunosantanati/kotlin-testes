package me.brunosantana

data class MyClassWithNullableField(
    val myField: String,
    var myNullableField: String? = null,
)

fun main() {
    val myObj = MyClassWithNullableField("field1")
    myObj.myNullableField = "field2"
    println(myObj)
}