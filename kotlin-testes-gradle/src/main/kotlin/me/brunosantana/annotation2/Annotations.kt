package me.brunosantana.annotation2

@Target(AnnotationTarget.FIELD)
annotation class ReplaceContent(val value: String)

@Target(AnnotationTarget.FIELD)
annotation class ReplaceContentForList(val value: String)