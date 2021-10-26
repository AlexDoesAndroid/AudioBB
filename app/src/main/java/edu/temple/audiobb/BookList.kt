package edu.temple.audiobb

import android.content.res.Resources

class BookList (resources: Resources) {

    var books: List<Book> =  listOf(
        Book(
            title = "title1",
            author = "author1"
        ),
        Book(
            title = "title2",
            author = "author2"
        )

    )

    /* Adds flower to liveData and posts value. */
    fun add(_book : Book) {
        val templist : List<Book> = listOf(_book)
        books + _book
    }

    /* Removes flower from liveData and posts value. */
    fun remove(_book : Book) {
        val templist : List<Book> = listOf(_book)
        books - _book
    }

    /* Returns book given an ID. */
    fun get(int: Int): Book {
        return books[int]
    }

    fun size(): Int {
        return books.size
    }

}