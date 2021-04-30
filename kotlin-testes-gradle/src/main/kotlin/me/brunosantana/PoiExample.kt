package me.brunosantana

import java.io.FileOutputStream
import java.io.IOException
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Kotlin example based on my own Gist: https://gist.github.com/brunosantanati/21dec49880fa9c56d4b9b5baabb656b1

// pass C:\\teste as a program argument
fun main(args: Array<String>) {
    writeXLSXFile(args[0])
}

@Throws(IOException::class)
fun writeXLSXFile(path: String) {
    val excelFileName = "$path\\Test.xlsx" // name of excel file
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
    val fileOut = FileOutputStream(excelFileName)

    // write this workbook to an Outputstream.
    wb.write(fileOut)
    fileOut.flush()
    fileOut.close()
}