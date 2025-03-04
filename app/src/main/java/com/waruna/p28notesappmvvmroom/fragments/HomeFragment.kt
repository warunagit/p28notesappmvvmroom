package com.waruna.p28notesappmvvmroom.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.waruna.p28notesappmvvmroom.MainActivity
import com.waruna.p28notesappmvvmroom.R
import com.waruna.p28notesappmvvmroom.adapter.NoteAdapter
import com.waruna.p28notesappmvvmroom.databinding.FragmentHomeBinding
import com.waruna.p28notesappmvvmroom.viewmodel.NoteViewModel
import com.waruna.p28notesappmvvmroom.*
import com.waruna.p28notesappmvvmroom.model.Note

class HomeFragment<Note> : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var notesViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = (activity as MainActivity).noteViewModel
        setUpRecyclerView()
        binding.btnAddNote.setOnClickListener{
            it.findNavController().navigate(
                R.id.action_homeFragment_to_newNoteFragment
            )
        }
    }

    private fun setUpRecyclerView(){
        noteAdapter = NoteAdapter()

        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = noteAdapter
        }
        activity.let{
            notesViewModel.getAllNotes().observe(
                viewLifecycleOwner,{
                    note-> noteAdapter.differ.submitList(note)
                    updateUI(note)
                }
            )
        }
    }

    private fun updateUI(note: List<com.waruna.p28notesappmvvmroom.model.Note>?) {
        if (note != null) {
            if (note.isNotEmpty()){
                binding.cardView.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            }else{
                binding.cardView.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.home_menu,menu)

        val mMenuSearch = menu.findItem(R.id.menu_search).actionView as SearchView
        mMenuSearch.isSubmitButtonEnabled = false
        mMenuSearch.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        //searchNote(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null){
            searchNote(newText)
        }
        return true
    }

    private fun searchNote(query: String?){
        val searchQuery = "%$query"
        notesViewModel.searchNote(searchQuery).observe(
            this,
            {list->noteAdapter.differ.submitList(list)}
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}