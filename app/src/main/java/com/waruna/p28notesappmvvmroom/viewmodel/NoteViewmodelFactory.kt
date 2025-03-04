package com.waruna.p28notesappmvvmroom.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waruna.p28notesappmvvmroom.repository.NoteRepository

class NoteViewmodelFactory(val application: Application,private  val noteRepository: NoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(application,noteRepository) as T
    }
}