package me.brunosantana.combine

data class OfferAllInformationDTO (
    val product: ProductDTO,
    val offer: OfferDTO
)

data class OfferDTO (
    val code: String,
    val name: String,
    val description: String,
    val coverages: List<CoverageDTO>
)

data class CoverageDTO (
    val code: String,
    val name: String,
    val description: String?
)

data class ProductDTO (
    val code: String,
    val name: String,
    val description: String
)