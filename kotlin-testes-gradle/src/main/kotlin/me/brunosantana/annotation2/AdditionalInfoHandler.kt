package me.brunosantana.annotation2

class AdditionalInfoHandler {

    fun replaceFieldsContent(offer: Offer, additionalInfo: Map<String, String>) {
        val fields = offer::class.java.declaredFields
        for (field in fields) {
            field.isAccessible = true
            for (annotation in field.annotations) {
                if (field.isAnnotationPresent(ReplaceContent::class.java)) {
                    val key = field.getAnnotation(ReplaceContent::class.java).value
                    val newContent = additionalInfo.get(key)
                    if(newContent != null) field.set(offer, newContent)
                }

            }
        }
    }

}