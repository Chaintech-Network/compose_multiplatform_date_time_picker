package com.example.datetimepicker

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.datetimepicker.ui.DatePickerListScreen

@Composable
fun MainView() {
    MaterialTheme {
        Navigator(
            screen = DatePickerListScreen()
        ) { navigator ->
            Scaffold {
                SlideTransition(navigator)
            }
        }
    }
}




