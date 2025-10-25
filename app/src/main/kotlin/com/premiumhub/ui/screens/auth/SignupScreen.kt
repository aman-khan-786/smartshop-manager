package com.premiumhub.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.premiumhub.ui.components.CustomButton
import com.premiumhub.ui.components.CustomTextField

@Composable
fun SignupScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    
    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sign Up") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Create Account",
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Join SmartShop Manager",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(32.dp))
            
            CustomTextField(
                value = name,
                onValueChange = { name = it; nameError = null },
                label = "Full Name",
                error = nameError
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = email,
                onValueChange = { email = it; emailError = null },
                label = "Email",
                error = emailError
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = password,
                onValueChange = { password = it; passwordError = null },
                label = "Password",
                error = passwordError,
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it; confirmPasswordError = null },
                label = "Confirm Password",
                error = confirmPasswordError,
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(24.dp))
            
            CustomButton(
                text = "Sign Up",
                onClick = {
                    // Validation
                    if (name.isEmpty()) {
                        nameError = "Name is required"
                        return@CustomButton
                    }
                    if (email.isEmpty()) {
                        emailError = "Email is required"
                        return@CustomButton
                    }
                    if (password.isEmpty()) {
                        passwordError = "Password is required"
                        return@CustomButton
                    }
                    if (password != confirmPassword) {
                        confirmPasswordError = "Passwords don't match"
                        return@CustomButton
                    }
                    
                    // TODO: Signup logic
                    navController.navigate("login") {
                        popUpTo("signup") { inclusive = true }
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            TextButton(onClick = { navController.navigateUp() }) {
                Text("Already have an account? Login")
            }
        }
    }
}