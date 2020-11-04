package me.bruno.santana

data class Error(val errorCode: String,
                 val message: String)

data class Errors(var errors: ArrayList<Error>){
    fun getErrors(): List<String> {
        return errors.map { "code=${it.errorCode} message=${it.message}" }
    }
}

fun main(){
    var errors = ArrayList<Error>()
    errors.add(Error("001", "The field 'X' is mandatory"))
    errors.add(Error("001", "The field 'Y' is mandatory"))

    var mapResult = Errors(errors).getErrors()

    for(item in mapResult){
        println(item)
    }
}