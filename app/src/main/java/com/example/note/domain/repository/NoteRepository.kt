package com.example.note.domain.repository

import com.example.note.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun editNote(note: Note)

    fun deleteNote(note: Note)

    fun getNotes(): List<Note>
}