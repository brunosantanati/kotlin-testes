package me.bruno.santana

//Code related to the video: https://cursos.alura.com.br/conhecendo-a-classe-string-do-kotlin-c226

fun main() {
    val x = 10
    var y = x //copy
    y++
    println(x)
    println(y)

    val p1 = Pessoa("Alex")
    val p2 = p1 //reference
    p2.nome = "Fran"
    println(p1.nome)
    println(p2.nome)

    //String is immutable
    val palavra = "palavra"
    var palavraNova = palavra
    palavraNova = "palavraNova"
    val substring = palavra.substring(4) //it generates another String, it does not modify palavra
    println(palavra)
    println(palavraNova)
    println(substring)

    for(c in palavra){
        println(c == 'a') //compare each char from String to the 'a' char
    }
}

class Pessoa(var nome: String)