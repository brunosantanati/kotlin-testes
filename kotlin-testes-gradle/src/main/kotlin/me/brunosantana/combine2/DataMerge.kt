package me.brunosantana.combine2

class DataMerge {
    /**
     * json2 overrides json1
     */
    fun jsonMerge(json1: String, json2: String): String?{
        val map1 = jsonStringToMap(json1)
        val map2 = jsonStringToMap(json2)
        val mapMerge = (map1 - map2)+map2
        return mapToJsonString(mapMerge);
    }
}

fun main(args: Array<String>) {
    val path = args[0] //pass via program argument the path of the resources folder
    val jsonOffer = readFileAsText(path = path, fileName = "offer.json")
    val jsonOfferExtras = readFileAsText(path = path, fileName = "offerExtra2.json")
    println(DataMerge().jsonMerge(jsonOffer, jsonOfferExtras))
}