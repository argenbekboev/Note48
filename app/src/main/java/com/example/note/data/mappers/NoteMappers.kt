package com.example.note.data.mappers

import com.example.note.data.model.NoteEntity
import com.example.note.domain.model.Note

fun NoteEntity.toNote() = Note(
        id,
        title,
        description,
        createdAt
    )

fun Note.toNoteEntity() = NoteEntity(
    id,
    title,
    description,
    createdAt
)