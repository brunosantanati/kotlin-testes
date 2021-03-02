package me.brunosantana.annotation2

@Target(AnnotationTarget.FIELD)
annotation class ReplaceFieldContent(val value: String)

@Target(AnnotationTarget.FIELD)
annotation class ReplaceListContent(val value: String)