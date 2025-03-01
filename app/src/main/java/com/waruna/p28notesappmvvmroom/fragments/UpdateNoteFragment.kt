package com.waruna.p28notesappmvvmroom.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.waruna.p28notesappmvvmroom.R

/**
 * A simple [Fragment] subclass.
 * Use the [UpdateNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateNoteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_note, container, false)
    }

}