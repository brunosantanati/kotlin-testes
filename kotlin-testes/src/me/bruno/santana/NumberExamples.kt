package me.bruno.santana

//Link do vídeo sobre esse código: https://cursos.alura.com.br/conhecendo-a-classe-number-do-kotlin-c225

fun main() {
    val x: Int = 15
    val y: Double = 14.5
    var z = x //Faz cópia, não é via referência. O comportamente é igual primitivos embora sejam objetos.
    z += 10 //Isso não altera o x

    printNumber(x)
    printNumber(y)
    printNumber(z)

    println(x.toDouble())
    println(y.toInt())
}

fun printNumber(valor: Number){ //Int e Double herdam de Number
    println(valor)
}