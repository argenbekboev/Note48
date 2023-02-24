package com.example.note.domain.repository

import com.example.note.domain.model.Note
import com.example.note.domain.utils.Resource
import java.util.concurrent.Flow

interface NoteRepository {

    fun createNote(note: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun editNote(note: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun deleteNote(note: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

    fun getNotes(): kotlinx.coroutines.flow.Flow<Resource<List<Note>>>
}