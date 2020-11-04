package me.brunosantana

data class FulfillObjectConditionally(
    val type: String,
    val value: String,
    var document: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var evp: String? = null
)

fun main() {
    //val obj = FulfillObjectConditionally("1", "12345678910")
    //val obj = FulfillObjectConditionally("2", "bruno@bruno.com")
    //val obj = FulfillObjectConditionally("3", "+5511955554444")
    val obj = FulfillObjectConditionally("4", "kljflajlajflajflkajfljalfjal")

    when(obj.type){
        "1" -> obj.document = obj.value
        "2" -> obj.email = obj.value
        "3" -> obj.phone = obj.value
        "4" -> obj.evp = obj.value
    }

    println(obj)
}