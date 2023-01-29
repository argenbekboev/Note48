package com.example.note.domain.usecases

import com.example.note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val noteRepository: NoteRepository)
{
    fun getNotes() = noteRepository.getNotes()
}