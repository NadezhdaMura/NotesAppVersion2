package com.example.notesapp.data

import com.example.notesapp.NotesApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class NoteRepository {
   private val coroutineContext = Dispatchers.IO

    private val noteDao = NotesApplication.db.getNoteDao()
    suspend fun createNewNote(title: String, text: String) = withContext(coroutineContext){
        noteDao.insertNote(Note (title, text ))
        }

    suspend fun getAllNotes() = withContext(coroutineContext){
        noteDao.getAllNotes()
    }

    suspend fun deleteNote(note: Note) = withContext(coroutineContext){
        noteDao.deleteNote(note)
    }
}

