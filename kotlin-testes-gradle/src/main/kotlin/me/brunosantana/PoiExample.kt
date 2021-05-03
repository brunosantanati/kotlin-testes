package me.brunosantana

import org.apache.poi.ss.usermodel.Font
import org.apache.poi.xssf.usermodel.*
import java.io.FileOutputStream
import java.io.IOException

//Kotlin example based on my own Gist: https://gist.github.com/brunosantanati/21dec49880fa9c56d4b9b5baabb656b1
//Example how to format cells: https://www.mysamplecode.com/2012/06/apache-poi-generate-excel-report.html

// pass C:\\teste as a program argument
fun main(args: Array<String>) {
    writeXLSXFile(args[0])
}

@Throws(IOException::class)
fun writeXLSXFile(path: String) {
    val excelFileName = "$path\\Test.xlsx" // name of excel file
    val wb = XSSFWorkbook()

    //### Sheet 1 ###
    val sheetName = "Sheet1" // name of sheet
    val sheet: XSSFSheet = wb.createSheet(sheetName)

    // create headers manually
    val bold: Font = wb.createFont()
    bold.bold = true
    val csBold: XSSFCellStyle = wb.createCellStyle()
    csBold.setFont(bold)
    val headers = listOf("header 0", "header 1", "header 2", "header 3", "header 4")
    val row: XSSFRow = sheet.createRow(0)
    val iterator = headers.iterator()
    for((index, item) in iterator.withIndex()){
        val cell: XSSFCell = row.createCell(index)
        cell.setCellValue(item)
        cell.cellStyle = csBold
    }

    // iterating r number of rows
    for (r in 1..5) {
        val row: XSSFRow = sheet.createRow(r)

        // iterating c number of columns
        for (c in 0..4) {
            val cell: XSSFCell = row.createCell(c)
            cell.setCellValue("Cell $r $c")
        }
    }

    //### Sheet 2 ###
    val sheetName2 = "Sheet2" // name of sheet
    val sheet2: XSSFSheet = wb.createSheet(sheetName2)
    // iterating r number of rows
    for (r in 0..4) {
        val row: XSSFRow = sheet2.createRow(r)

        // iterating c number of columns
        for (c in 0..4) {
            val cell: XSSFCell = row.createCell(c)
            cell.setCellValue("[2] Cell $r $c")
        }
    }

    val fileOut = FileOutputStream(excelFileName)

    // write this workbook to an Outputstream.
    wb.write(fileOut)
    fileOut.flush()
    fileOut.close()
}