package me.brunosantana.annotation2

import java.lang.reflect.Field

class AdditionalInfoHandler {

    fun replaceFieldsContent(
        offer: Offer,
        additionalInfo: Map<String, String>,
        additionalInfoForLists: Map<String, Map<String, String>>
    ) {
        val fields = offer::class.java.declaredFields
        for (field in fields) {
            field.isAccessible = true
            for (annotation in field.annotations) {
                if (field.isAnnotationPresent(ReplaceContent::class.java)) {
                    replaceFieldContent(field, additionalInfo, offer)
                }else if(field.isAnnotationPresent(ReplaceContentForList::class.java)){
                    replaceContentFromList(field, additionalInfoForLists, offer)
                }
            }
        }
    }

    private fun replaceFieldContent(
        field: Field,
        additionalInfo: Map<String, String>,
        offer: Offer
    ) {
        val key = field.getAnnotation(ReplaceContent::class.java).value
        val newContent = additionalInfo.get(key)
        if (newContent != null) field.set(offer, newContent)
    }

    private fun replaceContentFromList(
        field: Field,
        additionalInfoForLists: Map<String, Map<String, String>>,
        offer: Offer,
    ){
        val annotationValue = field.getAnnotation(ReplaceContentForList::class.java).value
        if(annotationValue == "coverages"){
            val value = field.get(offer)
            val coverages = value as List<Coverage>
            for(coverage in coverages){
                val coverageFields = coverage::class.java.declaredFields
                for (coverageField in coverageFields) {
                    coverageField.isAccessible = true
                    for (annotation in coverageField.annotations) {
                        if (coverageField.isAnnotationPresent(ReplaceContent::class.java)) {
                            val key = coverageField.getAnnotation(ReplaceContent::class.java).value
                            val coverageMap = additionalInfoForLists.get(key)
                            if (coverageMap?.get(coverage.id) != null) {
                                val newContent = coverageMap?.get(coverage.id)
                                coverageField.set(coverage, newContent)
                            }
                        }
                    }
                }
            }
        }else if(annotationValue == "benefits"){
            val value = field.get(offer)
            val benefits = value as List<Benefit>
            for(benefit in benefits){
                val benefitFields = benefit::class.java.declaredFields
                for (benefitField in benefitFields) {
                    benefitField.isAccessible = true
                    for (annotation in benefitField.annotations) {
                        if (benefitField.isAnnotationPresent(ReplaceContent::class.java)) {
                            val key = benefitField.getAnnotation(ReplaceContent::class.java).value
                            val benefitMap = additionalInfoForLists.get(key)
                            if (benefitMap?.get(benefit.id) != null) {
                                val newContent = benefitMap?.get(benefit.id)
                                benefitField.set(benefit, newContent)
                            }
                        }
                    }
                }
            }
        }
    }

}