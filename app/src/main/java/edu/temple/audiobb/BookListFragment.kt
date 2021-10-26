package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




class BookListFragment : Fragment() {
    private var param1: List<Book>?=null
    private lateinit var layout:View
    private lateinit var books : List<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable("startupIndex") as List<Book>
            books = param1 as List<Book>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    companion object {
        fun newInstance(booklist: BookList) {
            val fragment = BookListFragment()
            val bundle: Bundle = Bundle()

            bundle.putSerializable("startupIndex", booklist)
            fragment.arguments = bundle

            return fragment
        }

    }
}