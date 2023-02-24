package com.example.note.presentation.ui.fragments.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.domain.model.Note
import com.example.note.domain.usecases.DeleteNoteUseCase
import com.example.note.domain.usecases.GetNoteUseCase
import com.example.note.domain.utils.Resource
import com.example.note.presentation.ui.fragments.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(

    private val getNoteUseCase: GetNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase

): ViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNotesState = _getNotesState.asStateFlow()

    private val _deleteNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNotesState = _deleteNotesState.asStateFlow()

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            getNoteUseCase.getNotes().collect {
                when (it) {
                    is Resource.Error<*> -> {
                        _getNotesState.value = UIState.Error(it.message!!)
                    }
                    is Resource.Loading<*> -> {
                        _getNotesState.value = UIState.Loading()
                    }
                    is Resource.Success<*> -> {
                        if (it.data != null)
                            _getNotesState.value = UIState.Success(it.data)
                    }
                }
            }
        }
        fun deleteNote(note: Note) {
            viewModelScope.launch(Dispatchers.IO) {
                deleteNoteUseCase.deleteNote(note).collect {
                    when (it) {
                        is Resource.Error<*> -> {
                            _deleteNotesState.value = UIState.Error(it.message!!)
                        }
                        is Resource.Loading<*> -> {
                            _deleteNotesState.value = UIState.Loading()
                        }
                        is Resource.Success<*> -> {
                            if (it.data != null)
                                _deleteNotesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}