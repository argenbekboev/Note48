package com.example.note.data.repository

import com.example.note.data.local.NoteDao
import com.example.note.data.mappers.toNote
import com.example.note.data.mappers.toNoteEntity
import com.example.note.data.model.NoteEntity
import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    override fun createNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNotes(): List<Note> {
        return noteDao.getNotes().map { it.toNote() }
    }
}
