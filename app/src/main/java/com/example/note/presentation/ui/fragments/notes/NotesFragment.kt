package com.example.note.presentation.ui.fragments.notes

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.note.R
import com.example.note.databinding.FragmentNotesBinding
import com.example.note.presentation.base.BaseFragment
import com.example.note.presentation.ui.fragments.UIState
import com.example.note.presentation.ui.fragments.notes.adapter.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment: BaseFragment(R.layout.fragment_notes) {

    private val viewModel by viewModels<NotesViewModel>()
    private val notesAdapter by lazy { NotesAdapter() }
    private val binding by viewBinding(FragmentNotesBinding::bind)

    override fun initialize() {
        setupNoteRecycler()
    }

    override fun setupListener() {
        binding.fabAddEdiNotes.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_add_edit_notesFragment)
        }
    }

    override fun setupRequests() {
        viewModel.getNotes()
    }

    override fun setupSubscribers() {
        viewModel.getNotesState.collectState(
            onLoading = {
                binding.progress.isVisible = true
            },
            onError = {
                binding.progress.isVisible = false
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                binding.progress.isVisible = false
                notesAdapter.submitList(it)
            }
        )
    }

    private fun setupNoteRecycler() = with(binding.recyclerNotes) {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
    }
}
