package me.bruno.santana

data class Document(
    val cpf: String?,
    val cnpj: String?
)

fun main() {

    //val documentNumber = "78945612365"
    val documentNumber = "78945612365145"

    print("CPF? ")
    println(if(isCPF("78945612365")) "yes" else "no")
    print("CNPJ? ")
    println(if(!isCPF("78945612365145")) "yes" else "no")

    val document = Document(
        cpf = if(isCPF(documentNumber)) documentNumber else null,
        cnpj = if(!isCPF(documentNumber)) documentNumber else null
    )

    println(document)
}

fun isCPF(document: String) = document.length <= 11