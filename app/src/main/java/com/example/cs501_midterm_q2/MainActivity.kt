package com.example.cs501_midterm_q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.cs501_midterm_q2.ui.theme.Cs501_midterm_q2Theme

class MainActivity : ComponentActivity() {
    val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cs501_midterm_q2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(
                        modifier = Modifier.padding(innerPadding),
                        counterViewModel = counterViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun CounterScreen(modifier: Modifier = Modifier, counterViewModel: CounterViewModel) {
    val count = counterViewModel.count

    Column(modifier = modifier) {
        Text("Count: $count")

        Button(onClick = { counterViewModel.increment() }) {
            Text("Increment")
        }
    }
}

class CounterViewModel : ViewModel() {
    var count by mutableStateOf(0)

    fun increment() {
        count++
    }
}