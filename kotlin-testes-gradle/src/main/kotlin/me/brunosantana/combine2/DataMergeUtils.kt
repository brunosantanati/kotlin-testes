package me.brunosantana.combine2

import com.beust.klaxon.Klaxon
import com.google.gson.Gson
import java.io.File

fun readFileAsText(path: String, fileName: String): String = File("${path}\\${fileName}").readText(Charsets.UTF_8)
fun jsonStringToMap(json: String): Map<String, Any> = Klaxon().parse<Map<String,Any>>(json)!!
fun mapToJsonString(map: Map<Any,Any>): String = Gson().toJson(map)