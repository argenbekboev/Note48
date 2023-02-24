package com.example.note.presentation.ui.fragments.add_edit

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.note.R
import com.example.note.databinding.FragmentAddEditNotesBinding
import com.example.note.domain.model.Note
import com.example.note.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditNotesFragment: BaseFragment(R.layout.fragment_add_edit_notes) {

    private val binding by viewBinding(FragmentAddEditNotesBinding::bind)
    private val viewModel by viewModels<AddEditNotesViewModel>()

    override fun setupListener() {
        binding.btnSave.setOnClickListener {
            viewModel.createNote(
                Note(
                title = binding.etTitle.text.toString(),
                description = binding.etDescription.text.toString(),
                createdAt = System.currentTimeMillis()
                )
            )
        }
    }

    override fun setupSubscribers() {
        viewModel.createNoteState.collectState(
            onLoading = {

            },
            onError = {

            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }
}

