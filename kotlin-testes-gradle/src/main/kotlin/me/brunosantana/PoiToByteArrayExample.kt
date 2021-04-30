package me.brunosantana

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import java.io.IOException
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

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

fun main() {
    val s3: AmazonS3 = AmazonS3ClientBuilder.defaultClient()
    s3.putObject("bruno-csv-bucket", "test.xlsx", getXlsxAsByteArray(), null);
}

@Throws(IOException::class)
fun getXlsxAsByteArray(): InputStream {
    val sheetName = "Sheet1" // name of sheet
    val wb = XSSFWorkbook()
    val sheet: XSSFSheet = wb.createSheet(sheetName)

    // iterating r number of rows
    for (r in 0..4) {
        val row: XSSFRow = sheet.createRow(r)

        // iterating c number of columns
        for (c in 0..4) {
            val cell: XSSFCell = row.createCell(c)
            cell.setCellValue("Cell $r $c")
        }
    }

    val stream = ByteArrayOutputStream()

    // write this workbook to an Outputstream.
    wb.write(stream)
    stream.flush()
    stream.close()

    return ByteArrayInputStream(stream.toByteArray())
}