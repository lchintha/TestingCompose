package com.lchintha.testingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lchintha.testingapp.room.NoteDao
import com.lchintha.testingapp.room.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val noteDao: NoteDao) : ViewModel() {

    val allNotes: Flow<List<NoteEntity>> = noteDao.getAllNotes()

    fun insert(note: NoteEntity) = viewModelScope.launch {
        noteDao.insert(note)
    }

}