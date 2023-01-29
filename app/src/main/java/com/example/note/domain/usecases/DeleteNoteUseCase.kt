package com.example.note.domain.usecases

import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository

class DeleteNoteUseCase(

    private val noteRepository: NoteRepository
) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}