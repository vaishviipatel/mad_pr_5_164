package com.example.practical_5_mad_22012011082.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practical_5_mad_22012011082.R

@Composable
fun Login(onSignUpClick: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        // Logo Image
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "profile",
            modifier = Modifier
                .height(130.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Login Card
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Form fields
                FormField(labelString = "Email")
                FormField(labelString = "Password", isPasswordField = true)

                // Forgot Password link
                Text(
                    text = "Forgot Password?",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.End)
                )

                // Login Button
                Button(
                    onClick = {
                        // Login logic here
                    },
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                ) {
                    Text("Login", fontSize = 18.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Don't have an account? SIGN UP text
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don't have an account? ",
                fontSize = 16.sp
            )
            TextButton(onClick = onSignUpClick) {
                Text(
                    text = "SIGN UP",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun FormField(
    labelString: String,
    isPasswordField: Boolean = false,
    isNumber: Boolean = false
) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        label = { Text(labelString) },
        placeholder = { Text("Enter $labelString") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        keyboardOptions = if (isNumber) {
            KeyboardOptions(keyboardType = KeyboardType.Number)
        } else {
            KeyboardOptions.Default
        },
        visualTransformation = if (isPasswordField) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    Login()
}