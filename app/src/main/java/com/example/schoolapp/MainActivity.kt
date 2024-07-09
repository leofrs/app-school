package com.example.schoolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.example.schoolapp.model.NotasModel
import com.example.schoolapp.ui.theme.SchoolAppTheme
import com.example.schoolapp.views.NotasView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    NotasView(
                        item = NotasModel(1,"Leonardo","Matemática",9, 7),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
