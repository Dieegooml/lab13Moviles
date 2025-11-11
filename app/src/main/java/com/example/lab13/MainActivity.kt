package com.example.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab13.ejercicios.caja
import com.example.lab13.ejercicios.cambioColor
import com.example.lab13.ejercicios.cambioContenido
import com.example.lab13.ejercicios.combinado
import com.example.lab13.ejercicios.tamanoPosicion
import com.example.lab13.ui.theme.Lab13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab13Theme {
                combinado()
            }
        }
    }
}


