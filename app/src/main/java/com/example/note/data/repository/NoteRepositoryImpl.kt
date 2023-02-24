package com.example.note.data.repository

import com.example.note.data.local.base.BaseRepository
import com.example.note.data.local.NoteDao
import com.example.note.data.mappers.toNote
import com.example.note.data.mappers.toNoteEntity
import com.example.note.data.model.NoteEntity
import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository
import com.example.note.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao) :
    NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNotes(): kotlinx.coroutines.flow.Flow<Resource<List<Note>>> = doRequest {
            noteDao.getNotes().map { it.toNote() }
    }
}




