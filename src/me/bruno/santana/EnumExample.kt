package me.bruno.santana

enum class DictTypeEnum(val type: Int){
    DOCUMENT(1),
    EMAIL(2),
    PHONE(3),
    EVP(4)
}

fun getDictType(key: String): Int{
    return when {
        key.startsWith("+") -> DictTypeEnum.PHONE.type
        key.contains("@") -> DictTypeEnum.EMAIL.type
        key.matches("^\\d{11,}\$".toRegex()) -> DictTypeEnum.DOCUMENT.type //11 or more digits
        else -> DictTypeEnum.EVP.type
    }
}

fun main() {

    val document: DictTypeEnum = DictTypeEnum.DOCUMENT
    println(document)

    val type: Int = DictTypeEnum.DOCUMENT.type
    println(type)

    println(DictTypeEnum.EMAIL.type)
    println(DictTypeEnum.PHONE.type)
    println(DictTypeEnum.EVP.type)

    println("############## Discover Dict Type ################")
    println(getDictType("06341897000101"))
    println(getDictType("bruno@bruno.com"))
    println(getDictType("+5511991918538"))
    println(getDictType("0a02d8e4-b108-45ca-b8b3-9dc6e29cfa2a"))
}