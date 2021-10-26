package edu.temple.audiobb

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class bookModel: ViewModel() {

    val bookLiveData: MutableLiveData<Book> = MutableLiveData<Book>()

    fun getItem(): LiveData<Book>? {
        bookLiveData
        return bookLiveData
    }

    fun setItem(_book : Book){
        bookLiveData
        bookLiveData.value = _book
    }




}