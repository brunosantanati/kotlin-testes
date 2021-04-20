package me.brunosantana

import java.util.ArrayList
import com.opencsv.CSVWriter
import com.opencsv.bean.StatefulBeanToCsvBuilder
import com.opencsv.bean.StatefulBeanToCsv
import java.io.FileWriter
import java.io.Writer

//Exemplo baseado em https://www.baeldung.com/opencsv

data class WriteExampleBean(
    val colA: String,
    val colB: String,
    val colC: String,
    val colD: Long,
    val colE: Float,
)

//passar "C:\\Users\\my-user-here\\Documents\\teste.csv" nos argumentos do programa
fun main(args: Array<String>) {
    val writer: Writer = FileWriter(args[0])

    val sbc: StatefulBeanToCsv<WriteExampleBean> = StatefulBeanToCsvBuilder<WriteExampleBean>(writer)
        //.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
        .withSeparator(';')
        .build()

    val list: MutableList<WriteExampleBean> = ArrayList<WriteExampleBean>()
    list.add(WriteExampleBean("Test1", "sfdsf", "fdfd", 10, 20.0f))
    list.add(WriteExampleBean("Test2", "ipso", "facto", 10, 37.8f))

    sbc.write(list)
    writer.close()
}