package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView



class BookListFragment : Fragment() {
    private var param1: List<Book>?=null
    private lateinit var layout:View
    private lateinit var  recyclerView:View
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
        layout = inflater.inflate(R.layout.fragment_book_list, container, false)
        recyclerView = layout.findViewById(R.id.recyclerView)
        
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            val bookList
            ViewModelProvider(requireActivity()).get(bookModel::class.java).setBook(books.get(itemPosition))
            (activity as EventInterface).selectionMade()

        }
        
        recyclerView.adapter = bookAdapter(requireActivity(), books, onClickListener)
        return layout
    }


    companion object {
        fun newInstance(booklist: BookList): BookListFragment {
            val fragment = BookListFragment()
            val bundle: Bundle = Bundle()

            bundle.putSerializable("startupIndex", booklist)
            fragment.arguments = bundle

            return fragment
        }

    }

    interface EventInterface {
        fun selectionMade()
    }
}