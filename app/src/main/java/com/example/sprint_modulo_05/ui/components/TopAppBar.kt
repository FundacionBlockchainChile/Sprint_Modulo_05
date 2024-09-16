package com.example.sprint_modulo_05.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    navController: NavController,
    title: String,
    showBackButton: Boolean = false, // Mostrar botón de retroceso
    onCartClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, // Icono de retroceso de Material Icons
                        contentDescription = "Back"
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { onCartClick() }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart, // Icono del carrito de Material Icons
                    contentDescription = "Carrito"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}
