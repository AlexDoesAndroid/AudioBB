package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BookDetailsFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onStart() {
        super.onStart()
        val itemModel: bookModel = ViewModelProvider(requireActivity()).get(bookModel::class.java)
    }

    private lateinit var layout:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        layout = inflater.inflate(R.layout.fragment_book_details, container, false)
        //var DisplayItem = intent.getSerializableExtra("Items") as Item
        imageView = layout.findViewById<ImageView>(R.id.imageView)
        textView = layout.findViewById<TextView>(R.id.textView)

        // imageView.setImageResource(DisplayItem.resourceId)
        //textView.text = DisplayItem.description
        ViewModelProvider(requireActivity())
            .get(bookModel::class.java)
            .getItem()?.observe(requireActivity(), {
                changeItem(it)
            })
        return layout
    }
    private fun changeItem(_book:Book) {
        imageView.setImageResource(_book.resourceId)
        textView.text = _item.description

    }


}