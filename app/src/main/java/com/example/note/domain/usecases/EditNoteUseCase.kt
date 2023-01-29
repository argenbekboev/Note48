package com.example.note.domain.usecases

import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository

class EditNoteUseCase(

    private val noteRepository: NoteRepository
) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}