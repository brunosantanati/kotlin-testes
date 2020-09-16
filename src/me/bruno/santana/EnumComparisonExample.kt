package me.bruno.santana

enum class DictType {
    EMAIL, PHONE, OTHER
}

fun main() {
    println(isEmail(DictType.EMAIL))
    println(isEmail(DictType.PHONE))
    println(isEmail(DictType.OTHER))
}

fun isEmail(dictType: DictType): Boolean = dictType == DictType.EMAIL