package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var twoPane = false
    lateinit var bookModel: bookModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Flag to determine whether there is one or two fragment containers
        twoPane = findViewById<View>(R.id.fragmentContainerView2) != null

        bookModel = ViewModelProvider(this).get(bookModel::class.java)

        // Pop DisplayFragment from stack if color was previously selected,
        // but user has since cleared selection
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                    is BookDetailsFragment
            && bookModel.getBook().value == null)
            supportFragmentManager.popBackStack()


        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) is BookDetailsFragment
            && twoPane)
            supportFragmentManager.popBackStack();

        val colors = arrayOf("Red", "Blue", "Green", "White", "Purple")

        // If fragment was not previously loaded (first time starting activity)
        // then add SelectionFragment

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, BookListFragment.newInstance(colors))
                .commit()


        if (twoPane) {
            if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) == null)
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView2, BookDetailsFragment())
                    .commit()
        } else if(!bookModel.getBook()?.value == null) { // If moving to single-pane
            supportFragmentManager.beginTransaction()                 // but a color was selected
                .add(R.id.fragmentContainerView, BookDetailsFragment())              // before the switch
                .addToBackStack(null)
                .commit()
        }
    }

    // A message from the fragment whenever the _event_
    // of selecting a color takes place
    override fun selectionMade() {
        // only respond if there is a single container
        if (!twoPane)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, BookDetailsFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        // A single way to "clear" the selected book so that
        // if doesn't remain selected. Remove it when the user
        // hits Back
        bookModel.setBook("")
    }

}