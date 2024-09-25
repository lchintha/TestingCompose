package com.lchintha.testingapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lchintha.testingapp.room.NoteEntity

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesListScreen(
    navController: NavController,
    mainViewModel: MainViewModel
) {
    val allNotes: State<List<NoteEntity>> = mainViewModel.allNotes.collectAsState(initial = listOf())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add_note")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) {
        LazyColumn (
            modifier = Modifier.padding(40.dp)
        ) {
            items(allNotes.value) { note ->
                Text(text = note.title)
                Spacer(modifier= Modifier.height(10.dp))
                Text(text = note.content)
            }
        }
    }
}