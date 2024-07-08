package com.example.schoolapp.views

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotasView() {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var expanded1 by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded1) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    Box(){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(2.dp, color = Color.Red),
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "Matemática"
                    )
                    IconButton(onClick = { expanded1 = !expanded1 }) {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            imageVector = if (expanded1) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = "Seta para baixo"
                        )
                    }
                }
            }
            if (expanded1){
                Box(
                    modifier = Modifier.padding(vertical = extraPadding)
                ){
                    Column {
                        Text(text = "Nota 1")
                        Text(text = "Nota 2")
                        Text(text = "Nota 3")
                        Text(text = "Nota 4")
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(2.dp, color = Color.Red),
                onClick = { /*TODO*/ }
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "Portugues"
                    )
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = "Seta para baixo"
                        )
                    }
                }
            }
            if (expanded){
                Box(
                    modifier = Modifier.padding(vertical = extraPadding)
                ){
                    Text(text = "Conteudo aqui")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotasPreview() {
    NotasView()
}