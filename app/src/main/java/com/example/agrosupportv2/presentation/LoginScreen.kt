package com.example.agrosupportv2.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.sharp.Email
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agrosupportv2.R


@Composable
fun LoginScreen(navController: NavController) {
    val emailState = remember { mutableStateOf("") }

    Scaffold {
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.starheader),
                contentDescription = "Header star Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = "Iniciar Sesión",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                ),
                textAlign = TextAlign.Left // Centrado
            )

            // TextField para correo electrónico
            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Correo electrónico") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp)), // Fondo blanco y borde redondeado
                singleLine = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Sharp.Email,
                        contentDescription = "Email"
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // TextField para contraseña
            PasswordTextField()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "¿Olvidaste tu contraseña?",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable { navController.navigate("forgotPassword") },
                    color = Color.Black,
                    fontSize = 14.sp
                )
            }


            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth().padding(16.dp),

                colors = ButtonDefaults.buttonColors(Color(0xFF092C4C))
            ) {
                Text(text = "Iniciar Sesión", color = Color.White)
            }
            // Spacer para empujar el texto hacia abajo
            Spacer(modifier = Modifier.weight(1f))

            // Texto clickable
            val text = buildAnnotatedString {
                append("¿No tienes cuenta ")
                pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                append("Crea tu cuenta")
                pop()
            }

            ClickableText(
                text = text,
                onClick = { offset ->
                    // Obtener el índice de "Crear cuenta" en el texto
                    val startIndex = text.indexOf("Crea tu cuenta")
                    val endIndex = startIndex + "Crea tu cuenta".length

                    if (offset in startIndex until endIndex) {
                        //navController.navigate("")
                        //CREATE ACCOUNT SECTION
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    val passwordVisualTransformation = remember { PasswordVisualTransformation() }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            passwordVisualTransformation
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp)), // Fondo blanco y borde redondeado
        trailingIcon = {
            Icon(
                imageVector = if (showPassword) {
                    Icons.Filled.Favorite
                } else {
                    Icons.Filled.FavoriteBorder
                },
                contentDescription = "Toggle password visibility",
                modifier = Modifier
                    .clickable { showPassword = !showPassword }
            )
        }
    )
}
