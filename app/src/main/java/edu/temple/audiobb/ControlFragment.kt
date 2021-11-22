package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso



class ControlFragment : Fragment() {

    lateinit var playButton: Button
    lateinit var pauseButton: Button
    lateinit var stopButton: Button
    lateinit var seekBar: AbsSeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_control, container, false)

        playButton= layout.findViewById(R.id.playButton)
        pauseButton = layout.findViewById(R.id.pauseButton)
        stopButton = layout.findViewById(R.id.stopButton)
        seekBar = layout.findViewById(R.id.seekBar)

        playButton.setOnClickListener {
           // AudLibPlayer.play(id: Int)
        }

        pauseButton.setOnClickListener {
          //  AudLibPlayer.pause()
        }

        stopButton.setOnClickListener {
           // AudLibPlayer.stop()
        }

            //  fun setOnSeekBarChangeListener(l: SeekBar.OnSeekBarChangeListener): Unit {}


        return layout
        }


                companion object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of fragment ControlFragment.
             */
            // TODO: Rename and change types and number of parameters
            @JvmStatic fun newInstance(param1: String, param2: String) =
                ControlFragment().apply {
                    arguments = Bundle().apply {
                       //putString(ARG_PARAM1, param1)
                        //putString(ARG_PARAM2, param2)
                    }
                }
        }
}