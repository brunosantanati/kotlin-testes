package me.brunosantana.json2

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File

// Example based on this tutorial: https://medium.com/nplix/how-to-read-and-write-json-data-in-kotlin-with-gson-c2971fd2d124

fun main(args: Array<String>) {
    var gson = Gson()
    val path = args[0] //pass via program argument the path of the file in the resources folder
    val bufferedReader: BufferedReader = File(path).bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    println(inputString)

    var offerAllInformation = gson.fromJson(inputString, OfferAllInformation::class.java)
    println(offerAllInformation)
    println(offerAllInformation.product.name)
}