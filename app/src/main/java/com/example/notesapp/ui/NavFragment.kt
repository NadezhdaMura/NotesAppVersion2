package com.example.notesapp.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.notesapp.R
import kotlinx.android.synthetic.main.fragment_navigation.*

class NavFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var sound = MediaPlayer.create(requireContext(), R.raw.sound)
        createNewButtonNav.setOnClickListener {
            sound!!.start()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,CreatingFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        listOfNotes.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,ListFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

    }

}