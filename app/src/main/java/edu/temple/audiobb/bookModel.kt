package edu.temple.audiobb

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class bookModel: ViewModel() {

    val bookLiveData: MutableLiveData<Book> = MutableLiveData<Book>()

    fun getBook(): LiveData<Book>? {
        bookLiveData
        return bookLiveData
    }

    fun setBook(_book : Book){
        bookLiveData
        bookLiveData.value = _book
    }




}