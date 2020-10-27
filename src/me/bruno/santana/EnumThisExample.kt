package me.bruno.santana

data class ClasseTeste(
        val enumTeste: EnumTeste
)

enum class EnumTeste{
    ITEM1,
    ITEM2,
    ITEM3
}

data class ClasseTeste2(
        val enumTeste: EnumTeste2
)

enum class EnumTeste2{
    ITEM1_2,
    ITEM2_2,
    ITEM3_2
}

fun ClasseTeste.to2() = ClasseTeste2(
    enumTeste = enumTeste.to2()
)

fun EnumTeste.to2() = when(this){
    EnumTeste.ITEM1 -> EnumTeste2.ITEM1_2
    EnumTeste.ITEM2 -> EnumTeste2.ITEM2_2
    EnumTeste.ITEM3 -> EnumTeste2.ITEM3_2
}

fun main() {
    println(ClasseTeste(EnumTeste.ITEM1).to2())
    println(ClasseTeste(EnumTeste.ITEM2).to2())
    println(ClasseTeste(EnumTeste.ITEM3).to2())
}