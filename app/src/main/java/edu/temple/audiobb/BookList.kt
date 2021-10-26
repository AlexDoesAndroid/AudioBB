package edu.temple.audiobb

import android.content.res.Resources

class BookList (resources: Resources) {

    var books: List<Book> =  listOf(
        Book(
            title = "A Middle English Vocabulary",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "Sir Gawain & The Green Knight",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "The Hobbit: or There and Back Again.",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "Farmer Giles of Ham",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "The Fellowship of the Ring",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "The Two Towers",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "The Return of the King",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "The Adventures of Tom Bombadil",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "Ancrene Wisse",
            author = "J.R.R. Tolkien"
        ),
        Book(
            title = "Smith of Wootton Major",
            author = "J.R.R. Tolkien"
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