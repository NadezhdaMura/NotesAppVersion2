package com.example.notesapp.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notesapp.R
import com.example.notesapp.data.NoteRepository
import kotlinx.android.synthetic.main.fragment_creating.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CreatingFragment : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_creating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val repo = NoteRepository()
        createNewButton.setOnClickListener {
            val title = editTextTitle.text.toString()
            val text = editTextText.text.toString()
            if (title.isNotBlank() && text.isNotBlank()) {
                launch {
                    val id = repo.createNewNote(title, text)
                    Toast.makeText(context, "Your entry is ready", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

}