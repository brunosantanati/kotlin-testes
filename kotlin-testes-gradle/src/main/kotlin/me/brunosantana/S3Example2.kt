package me.brunosantana

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import java.util.ArrayList
import com.opencsv.CSVWriter
import com.opencsv.ICSVWriter.*
import com.opencsv.bean.StatefulBeanToCsvBuilder
import com.opencsv.bean.StatefulBeanToCsv
import java.io.*


//https://www.baeldung.com/opencsv
//https://docs.aws.amazon.com/pt_br/sdk-for-java/v1/developer-guide/examples-s3-objects.html#upload-object
//https://docs.aws.amazon.com/pt_br/sdk-for-java/v1/developer-guide/setup-credentials.html

/*Antes de rodar criar os arquivos:

C:\Users\55119\.aws\config
[default]
region = us-east-2

C:\Users\55119\.aws\credentials
[default]
aws_access_key_id = [put_access_key_here]
aws_secret_access_key = [put_secret_key_here]

*/

data class MyBean2(
    val colA: String,
    val colB: String,
    val colC: String,
)

data class MyBean3(
    val colA: String,
    val colB: String,
    val colC: String,
    val calD: String,
)

fun main() {

    val bucketName = "bruno-csv-bucket"

    val s3: AmazonS3 = AmazonS3ClientBuilder.defaultClient()
    s3.putObject(bucketName, "my-test-2.csv", getCsvAsInputStream(), null);

    val list1: MutableList<MyBean2> = ArrayList<MyBean2>()
    list1.add(MyBean2("AAA", "BBB", "CCC"))
    list1.add(MyBean2("DDD", "EEE", "FFF"))
    s3.putObject(bucketName, "my-test-generic-1.csv", getCsvAsInputStreamGeneric(list1), null);

    val list2: MutableList<MyBean3> = ArrayList<MyBean3>()
    list2.add(MyBean3("AAA", "BBB", "CCC", "DDD"))
    list2.add(MyBean3("EEE", "FFF", "GGG", "HHH"))
    s3.putObject(bucketName, "my-test-generic-2.csv", getCsvAsInputStreamGeneric(list2), null);

}

fun getCsvAsInputStream(): InputStream {
    val stream = ByteArrayOutputStream()
    val streamWriter = OutputStreamWriter(stream)
    val writer = CSVWriter(streamWriter, ';',
        DEFAULT_QUOTE_CHARACTER, DEFAULT_ESCAPE_CHARACTER, RFC4180_LINE_END)

    val beanToCsv: StatefulBeanToCsv<MyBean2> = StatefulBeanToCsvBuilder<MyBean2>(writer)
        .build()

    val list: MutableList<MyBean2> = ArrayList<MyBean2>()
    list.add(MyBean2("Linha 1 Coluna A", "Linha 1 Coluna B", "Linha 1 Coluna C"))
    list.add(MyBean2("Linha 2 Coluna A", "Linha 2 Coluna B", "Linha 2 Coluna C"))

    beanToCsv.write(list)
    streamWriter.flush()

    return ByteArrayInputStream(stream.toByteArray());
}

fun <T: Any> getCsvAsInputStreamGeneric(list: List<T>): InputStream {
    val stream = ByteArrayOutputStream()
    val streamWriter = OutputStreamWriter(stream)
    val writer = CSVWriter(streamWriter, ';',
        DEFAULT_QUOTE_CHARACTER, DEFAULT_ESCAPE_CHARACTER, RFC4180_LINE_END)

    val beanToCsv: StatefulBeanToCsv<T> = StatefulBeanToCsvBuilder<T>(writer)
        .build()

    beanToCsv.write(list)
    streamWriter.flush()

    return ByteArrayInputStream(stream.toByteArray());
}