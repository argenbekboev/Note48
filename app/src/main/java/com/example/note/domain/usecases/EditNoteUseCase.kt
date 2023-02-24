package com.example.note.domain.usecases

import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(

    private val noteRepository: NoteRepository
) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}