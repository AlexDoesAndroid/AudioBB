package edu.temple.audiobb

import android.content.res.Resources
import java.io.Serializable

class BookList (): Serializable {

    var books: List<Book> =  listOf(

    )

    /* Adds flower to liveData and posts value. */
    fun add(_book : Book) {
        val templist : List<Book> = listOf(_book)
        books  = books + _book
    }
    fun add(_books : List<Book>) {
        books = books + _books
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