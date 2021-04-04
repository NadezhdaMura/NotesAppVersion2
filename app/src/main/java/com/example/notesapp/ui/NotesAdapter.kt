package com.example.notesapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.data.Note
import kotlinx.android.synthetic.main.notes_list_item.view.*

class NotesAdapter (
    private val deleteNote: (Note) -> Unit
): RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    private val notes: MutableList<Note> = mutableListOf()

    fun addNotes(newNotes: List<Note>){
        val  startIndex = notes.size
        notes.addAll(newNotes)
        notifyItemRangeInserted(startIndex, newNotes.size)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.NotesHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_list_item, parent, false)
        return NotesHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NotesAdapter.NotesHolder, position: Int) {
        holder.bind(notes[position]) {
             deleteNote(it) //удаляем из базы данных
            notes.removeAt(position) //удаляем из списка RecyclerView
            notifyItemRemoved(position) //ининциируем перерисовку
            notifyItemRangeChanged(position, itemCount)
        }
    }

    class NotesHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(note: Note, deleteNote: (Note) -> Unit) = itemView.apply {
            var list = listOf("#000000","#DD2929")
            var list2 = listOf(R.drawable.ic_delete,R.drawable.ic_delete_black,R.drawable.ic_delete_green,
            R.drawable.ic_delete_yellow)
            notesTitle.text = note.title
            notesText.text = note.text
            notesTitle.setTextColor(Color.parseColor(list.random()))
            notesText.setTextColor(Color.parseColor(list.random()))
            buttonDeleteNote.setImageDrawable(resources.getDrawable(list2.random()))
            buttonDeleteNote.setOnClickListener {
                deleteNote(note)
            }
        }

    }

}