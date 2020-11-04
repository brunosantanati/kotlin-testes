package me.bruno.santana

//Code based on video: https://cursos.alura.com.br/data-class-do-kotlin-c251

//links from documentation:
//https://kotlinlang.org/docs/reference/data-classes.html
//https://kotlinlang.org/docs/reference/multi-declarations.html
//https://kotlinlang.org/docs/reference/operator-overloading.html

fun main() {

    val alex = Pessoa2(
            nome = "Alex",
            idade = 25
    )
    val alex2 = Pessoa2(
            nome = "Alex",
            idade = 25
    )
    alex.fala()
    println(alex == alex2)

    val documento = Documento(
            rg = "12345678-9",
            cpf = "123.456.789-01"
    )
    val documento2 = Documento(
            rg = "12345678-9",
            cpf = "123.456.789-01"
    )
    //data class already has equals implemented based on fields
    println(documento == documento2)

    println(alex)
    //data class already has toString implemented using fields
    println(documento)

    val(nome) = alex
    println("Nome: $nome")

    //destructuring declarations
    val(rg, cpf) = documento
    println("RG: $rg CPF: $cpf")

    //copy
    val documento3 = documento.copy()
    println(documento == documento3) //It uses data class equals implementation
    println(documento3)

    val documento4 = documento.copy(
            rg = "12345698-8"
    )
    println(documento == documento4) //It uses data class equals implementation
    println(documento4)
}

class Pessoa2(val nome: String, val idade: Int){
    fun fala(){
        println("Emite som")
    }

    operator fun component1() = this.nome
}

data class Documento(val rg: String, val cpf: String)