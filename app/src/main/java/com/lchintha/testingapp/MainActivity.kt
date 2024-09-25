package com.lchintha.testingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lchintha.testingapp.room.AppDatabase
import com.lchintha.testingapp.ui.theme.TestingAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDatabase = AppDatabase.getDatabase(applicationContext)
        mainViewModel = MainViewModel(appDatabase.noteDao())

        enableEdgeToEdge()
        setContent {
            TestingAppTheme {
                NavigateApplication(viewModel = mainViewModel)
            }
        }
    }
}

@Composable
fun NavigateApplication(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "notes_list") {
        composable(route = "notes_list") {
            NotesListScreen(navController = navController, mainViewModel = viewModel)
        }
        composable(route = "add_note") {
            AddNoteScreen(navController = navController, mainViewModel = viewModel)
        }
    }
}
