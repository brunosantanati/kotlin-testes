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
                if (field.isAnnotationPresent(ReplaceFieldContent::class.java)) {
                    replaceFieldContent(field, additionalInfo, offer)
                }else if(field.isAnnotationPresent(ReplaceListContent::class.java)){
                    replaceListContent(field, additionalInfoForLists, offer)
                }
            }
        }
    }

    private fun replaceFieldContent(
        field: Field,
        additionalInfo: Map<String, String>,
        offer: Offer
    ) {
        val key = field.getAnnotation(ReplaceFieldContent::class.java).value
        val newContent = additionalInfo.get(key)
        if (newContent != null) field.set(offer, newContent)
    }

    private fun replaceListContent(
        field: Field,
        additionalInfoForLists: Map<String, Map<String, String>>,
        offer: Offer
    ){
        val annotationValue = field.getAnnotation(ReplaceListContent::class.java).value
        val value = field.get(offer)

        if(annotationValue == "coverages"){
            val coverages = value as List<Coverage>
            replaceContentFromEachItemOfList(additionalInfoForLists, coverages)
        }else if(annotationValue == "benefits"){
            val benefits = value as List<Benefit>
            replaceContentFromEachItemOfList(additionalInfoForLists, benefits)
        }
    }

    private fun <E> replaceContentFromEachItemOfList(
        additionalInfoForLists: Map<String, Map<String, String>>,
        listItems: List<E>
    ) where E: ReplaceableList {
        for(item in listItems){
            val itemFields = item!!::class.java.declaredFields
            for (itemField in itemFields) {
                itemField.isAccessible = true
                for (annotation in itemField.annotations) {
                    if (itemField.isAnnotationPresent(ReplaceFieldContent::class.java)) {
                        val key = itemField.getAnnotation(ReplaceFieldContent::class.java).value
                        val itemMap = additionalInfoForLists.get(key)
                        val newContent = itemMap?.get(item.id)
                        if (newContent != null) {
                            itemField.set(item, newContent)
                        }
                    }
                }
            }
        }
    }

}