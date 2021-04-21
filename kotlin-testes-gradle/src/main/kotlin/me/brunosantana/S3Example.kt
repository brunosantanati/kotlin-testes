package me.brunosantana

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import java.util.ArrayList
import com.opencsv.CSVWriter
import com.opencsv.bean.StatefulBeanToCsvBuilder
import com.opencsv.bean.StatefulBeanToCsv
import java.io.File
import java.io.FileWriter
import java.io.Writer

//https://www.baeldung.com/opencsv
//https://docs.aws.amazon.com/pt_br/sdk-for-java/v1/developer-guide/examples-s3-objects.html#upload-object

/*Antes de rodar criar os arquivos:

C:\Users\55119\.aws\config
[default]
region = us-east-2

C:\Users\55119\.aws\credentials
[default]
aws_access_key_id = [put_access_key_here]
aws_secret_access_key = [put_secret_key_here]

*/

data class MyBean(
    val colA: String,
    val colB: String,
    val colC: String,
    val colD: Long,
    val colE: Float,
)

//passar "C:\\Users\\my-user-here\\Documents\\teste.csv" nos argumentos do programa
fun main(args: Array<String>) {

    generateCsv(args)

    val s3: AmazonS3 = AmazonS3ClientBuilder.defaultClient()
    s3.putObject("bruno-csv-bucket", "my-test.csv", File(args[0]));

}

private fun generateCsv(args: Array<String>) {
    val writer: Writer = FileWriter(args[0])

    val sbc: StatefulBeanToCsv<MyBean> = StatefulBeanToCsvBuilder<MyBean>(writer)
        //.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
        .withSeparator(';')
        .build()

    val list: MutableList<MyBean> = ArrayList<MyBean>()
    list.add(MyBean("Test1", "sfdsf", "fdfd", 10, 20.0f))
    list.add(MyBean("Test2", "ipso", "facto", 10, 37.8f))

    sbc.write(list)
    writer.close()
}