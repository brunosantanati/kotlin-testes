package me.brunosantana.combine

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File

fun main(args: Array<String>) {
    val gson = Gson()
    val path = args[0] //pass via program argument the path of the file in the resources folder
    val pathExtras = args[1] //pass via program argument the path of the file in the resources folder

    val bufferedReader: BufferedReader = File(path).bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    println(inputString)

    println("########################")

    val bufferedReaderExtra: BufferedReader = File(pathExtras).bufferedReader()
    val inputStringExtra = bufferedReaderExtra.use { it.readText() }
    println(inputStringExtra)

    println("########################")

    val offerAllInformation = gson.fromJson(inputString, OfferAllInformation::class.java)
    val offerAllInformationExtra = gson.fromJson(inputStringExtra, OfferAllInformationExtra::class.java)

    val offerAllInformationDTO = combine(offerAllInformation, offerAllInformationExtra)
    println(offerAllInformationDTO)
}

fun combine(
    offerAllInformation: OfferAllInformation,
    offerAllInformationExtra: OfferAllInformationExtra
): OfferAllInformationDTO {

    val product = ProductDTO(
        code = offerAllInformation.product.code,
        name = offerAllInformationExtra.productExtra.nameExtra,
        description = offerAllInformationExtra.productExtra.descriptionExtra
    )

    val coverages = mutableListOf<CoverageDTO>()
    for (coverage in offerAllInformation.offer.coverages){
        val coverageExtra = offerAllInformationExtra.offerExtra.coveragesExtra.find { it.codeExtra == coverage.code }
        coverages.add(CoverageDTO(
            name = coverage.name,
            code = coverage.code,
            description = coverageExtra?.descriptionExtra
        ))
    }

    val offer = OfferDTO(
        code = offerAllInformation.offer.code,
        name = offerAllInformation.offer.name,
        description = offerAllInformationExtra.offerExtra.descriptionExtra,
        coverages = coverages
    )

    return OfferAllInformationDTO(
        product = product,
        offer = offer
    )
}