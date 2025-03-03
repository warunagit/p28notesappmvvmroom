package com.waruna.p28notesappmvvmroom.repository

import com.waruna.p28notesappmvvmroom.database.NoteDatabase
import com.waruna.p28notesappmvvmroom.model.Note

class NoteRepository(private val db: NoteDatabase) {
    //functions of DOA file
    suspend fun insertNote(note: Note) = db.getNoteDAO().insertNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDAO().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDAO().deleteNote(note)

    fun getAllNotes() = db.getNoteDAO().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDAO().searchNote(query)
}