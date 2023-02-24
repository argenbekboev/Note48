package com.example.note.presentation.ui.fragments.add_edit

import com.example.note.domain.model.Note
import com.example.note.domain.usecases.CreateNoteUseCase
import com.example.note.domain.usecases.EditNoteUseCase
import com.example.note.presentation.base.BaseViewModel
import com.example.note.presentation.ui.fragments.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddEditNotesViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun createNote(note: Note) {
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }
}