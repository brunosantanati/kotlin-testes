package me.bruno.santana

enum class DictTypeEnum(val type: Int){
    DOCUMENT(1),
    EMAIL(2),
    PHONE(3),
    EVP(4)
}

fun main() {

    val document: DictTypeEnum = DictTypeEnum.DOCUMENT
    println(document)

    val type: Int = DictTypeEnum.DOCUMENT.type
    println(type)

    println(DictTypeEnum.EMAIL.type)
    println(DictTypeEnum.PHONE.type)
    println(DictTypeEnum.EVP.type)
}