package com.example.schoolapp.views

import androidx.activity.ComponentActivity
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.schoolapp.model.NotasModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun NotasView(item: NotasModel, modifier: Modifier = Modifier) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color.Blue// Defina a cor que você deseja

    // Muda a cor da status bar
    systemUiController.setStatusBarColor(
        color = statusBarColor,
        darkIcons = false // Define se os ícones devem ser escuros ou claros
    )
    var expanded by rememberSaveable { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 2.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    Box(
       modifier = Modifier.background(Color.White).fillMaxSize()
    ){
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { expanded = !expanded }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = item.disciplina,
                        color = Color.White
                    )
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            modifier = Modifier.padding(end = 16.dp),
                            imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = "Seta para baixo",
                            tint = Color.White
                        )
                    }
                }
            }
            if (expanded){
                Box(
                    modifier = Modifier.padding(vertical = extraPadding)
                ){
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    border = BorderStroke(1.dp, color = Color.Blue),
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "Primeira nota: ${item.nota.toString()}"
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    border = BorderStroke(1.dp, color = Color.Blue),
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "Segunda nota: ${item.nota.toString()}"
                            )

                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    border = BorderStroke(1.dp, color = Color.Blue),
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "Terceira nota: ${item.nota.toString()}"
                            )

                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    border = BorderStroke(1.dp, color = Color.Blue),
                                    shape = RoundedCornerShape(50)
                                )
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                text = "Quarta nota: ${item.nota.toString()}"
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        if (item.notaFinal >= 7){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Green, shape = RoundedCornerShape(50)).border(border = BorderStroke(1.dp,Color.Black), shape = RoundedCornerShape(50))
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            )  {
                                Text(
                                    text = "Nota final: ${item.notaFinal.toString()}",

                                )
                            }

                        }else{
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Red, shape = RoundedCornerShape(50))
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            )  {
                                Text(
                                    text = "Nota final: ${item.notaFinal.toString()}",
                                    color = Color.White
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotasPreview() {
    NotasView(
        NotasModel(1,"Leonardo","Matemática",9, 6)
    )
}