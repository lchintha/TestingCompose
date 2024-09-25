package com.lchintha.testingapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lchintha.testingapp.room.NoteEntity

@Composable
fun AddNoteScreen(
    navController: NavController,
    mainViewModel: MainViewModel
) {
    var noteTitle by remember { mutableStateOf("") }
    var noteContent by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        TextField(
            value = noteTitle,
            onValueChange = { noteTitle = it },
            label = { Text(text = "Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = noteContent,
            onValueChange = { noteContent = it },
            label = { Text(text = "Content") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newNote = NoteEntity(title = noteTitle, content = noteContent)
                mainViewModel.insert(newNote)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Save")
        }
    }
}