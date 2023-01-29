package com.example.note.data.local

import com.example.note.data.model.NoteEntity

@Dao

interface NoteDao {

    @Insert
    fun createNote(noteEntity: NoteEntity)

    @Update
    fun editNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getNotes(): List<NoteEntity>
}