package com.example.agrosupportv2.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agrosupportv2.R

@Composable
fun RestorePasswordScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Sección que ocupa el 15% de la pantalla para la imagen y el botón
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f) // Ocupa el 15% de la altura
            ) {
                // Imagen de fondo (starheader)
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.starheader),
                    contentDescription = "Header star Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(), // La imagen ocupa todo el 15% de la sección
                    contentScale = ContentScale.FillBounds
                )

                // Botón de retroceso superpuesto en la parte superior izquierda
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 14.dp), // Separación del borde izquierdo de la pantalla movil
                    contentAlignment = Alignment.CenterStart // Botón alineado a la izquierda y centrado verticalmente

                ) {
                    IconButton(
                        onClick = { navController.popBackStack() }, // Acción de retroceso
                        modifier = Modifier
                            .size(40.dp) // Tamaño del botón
                            .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(8.dp) // Borde rectangular
                            )
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Ícono de retroceso
                            contentDescription = "Retroceder",
                            modifier = Modifier.size(24.dp), // Tamaño del ícono
                            tint = Color.Black // Color del ícono
                        )
                    }
                }
            }


        }
    }
}
