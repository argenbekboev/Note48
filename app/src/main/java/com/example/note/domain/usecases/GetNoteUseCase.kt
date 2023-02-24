package com.example.note.domain.usecases

import com.example.note.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository)
{
    fun getNotes() = noteRepository.getNotes()
}