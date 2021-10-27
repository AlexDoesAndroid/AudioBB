package edu.temple.audiobb
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class bookAdapter (_books : Array<Book>, _ocl : View.OnClickListener) : RecyclerView.Adapter<bookAdapter.ViewHolder>(){
    private val books = _books
    private val ocl = _ocl

    /**
     * ViewHolder Constructor accepts onClickListener
     * and assigns it to the included view
     */
    class ViewHolder(_view: TextView, ocl: View.OnClickListener) : RecyclerView.ViewHolder(_view) {
        val TextView = _view.apply { setOnClickListener(ocl) }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // View is dynamically generated instead of inflated
        // A ViewGroup.LayoutParams object is used
        // to provide _width_ and _height_
        return ViewHolder(TextView(parent.context).apply { layoutParams = ViewGroup.LayoutParams(300, 300) }, ocl)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.TextView.text = books[position].title
    }

    override fun getItemCount(): Int {
        return books.size
    }

}