package com.example.lab13.ejercicios

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun combinado() {
    var expandido by remember { mutableStateOf(false) }
    var mostrarBoton by remember { mutableStateOf(true) }
    var modoOscuro by remember { mutableStateOf(false) }

    val tamanoCaja by animateDpAsState(
        targetValue = if (expandido) 180.dp else 100.dp,
        animationSpec = spring(dampingRatio = 0.5f, stiffness = 200f)
    )

    val colorCaja by animateColorAsState(
        targetValue = if (expandido) Color(0xFF4CAF50) else Color(0xFF2196F3),
        animationSpec = tween(durationMillis = 800)
    )

    val colorFondo by animateColorAsState(
        targetValue = if (modoOscuro) Color(0xFF121212) else Color(0xFFF5F5F5),
        animationSpec = tween(durationMillis = 700)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(tamanoCaja)
                    .background(colorCaja)
            )

            Spacer(modifier = Modifier.height(24.dp))

            AnimatedVisibility(
                visible = mostrarBoton,
                enter = fadeIn(animationSpec = tween(700)) + slideInVertically(),
                exit = fadeOut(animationSpec = tween(700)) + slideOutVertically()
            ) {
                Button(onClick = {
                    expandido = !expandido
                    mostrarBoton = false
                }) {
                    Text("Cambiar tamaño y ocultar botón")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            AnimatedContent(
                targetState = modoOscuro,
                transitionSpec = {
                    fadeIn(animationSpec = tween(600)) with fadeOut(animationSpec = tween(600))
                },
                label = "Modo"
            ) { esOscuro ->
                Text(
                    text = if (esOscuro) "Modo Oscuro Activado" else "Modo Claro Activado",
                    fontSize = 20.sp,
                    color = if (esOscuro) Color.White else Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { modoOscuro = !modoOscuro }) {
                Text("Cambiar Modo")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { mostrarBoton = true }) {
                Text("Mostrar Botón de Nuevo")
            }
        }
    }
}