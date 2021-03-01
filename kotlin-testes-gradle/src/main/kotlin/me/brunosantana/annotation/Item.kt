package me.brunosantana.annotation

class Item(@Positive val amount: Float, @AllowedNames(["Alice", "Bob"]) val name: String)