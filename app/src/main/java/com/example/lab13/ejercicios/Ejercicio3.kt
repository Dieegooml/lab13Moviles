package com.example.lab13.ejercicios

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@Composable
fun tamanoPosicion() {
    var expandir by remember { mutableStateOf(false) }
    val tamano by animateDpAsState(
        targetValue = if (expandir) 150.dp else 80.dp,
        animationSpec = tween(durationMillis = 800)
    )

    val desplazamientox by animateDpAsState(
        targetValue = if (expandir) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 800)
    )

    val desplazamientoy by animateDpAsState(
        targetValue = if (expandir) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 800)
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.offset(x = desplazamientox, desplazamientoy).size(tamano).background(Color(0xFFFF9800))
        )

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { expandir = !expandir }) {
            Text(if (expandir) "Volver" else "Mover yagrandar")
        }
    }
}