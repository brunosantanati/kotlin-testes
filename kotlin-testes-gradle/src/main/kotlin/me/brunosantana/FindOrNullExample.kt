package me.brunosantana

data class BookShelf(
    val book1: Book,
    val book2: Book,
    val book3: Book,
)

data class Book(
    val author: String,
    val title: String,
)

fun main() {
    val books = listOf(
        Book("John Piper", "Fome por Deus"),
        Book("John Piper", "Desiring God"),
        Book("Augustus Nicodemus", "Mantendo a Igreja Pura")
    )

    val book1 = books.firstOrNull { it.title == "Fome por Deus" }
    val book2 = books.firstOrNull { it.title == "Título inexistente" }
    val book3 = books.firstOrNull { it.title == "Mantendo a Igreja Pura" }

    val bookShelf = BookShelf(
        book1 = Book("", "Fome por Deus"),
        book2 = Book("", "Desiring God"),
        book3 = Book("", "Mantendo a Igreja Pura")
    )

    println(bookShelf)

    val copy = bookShelf.copy(
        book1 = bookShelf.book1.copy(
            author = book1?.author ?: ""
        ),
        book2 = bookShelf.book2.copy(
            author = book2?.author ?: ""
        ),
        book3 = bookShelf.book3.copy(
            author = book3?.author ?: ""
        )
    )

    println(copy)
}