package com.example.notesapp.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "notes")
data class Note(
    val title: String,
    val text: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)


