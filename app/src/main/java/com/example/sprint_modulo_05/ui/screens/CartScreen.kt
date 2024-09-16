package com.example.sprint_modulo_05.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sprint_modulo_05.ui.components.AppTopBar
import com.example.sprint_modulo_05.ui.components.CartItemCard
import com.example.sprint_modulo_05.ui.viewmodel.CartViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel, navController: NavController) {
    val cartItems by cartViewModel.cartItems.observeAsState(emptyList())

    // Calcular el total de productos y el valor total del carrito
    val totalItems = cartItems.size
    val totalPrice = cartItems.sumOf { it.price }

    Scaffold(
        topBar = {
            AppTopBar(
                navController = navController,
                title = "Carrito",
                showBackButton = true,
                onCartClick = { /* Ya estamos en la pantalla del carrito */ }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            // Resumen de la compra
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column {
                    Text(
                        text = "Resumen de la compra",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Total de productos: $totalItems",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Total a pagar: $${"%.2f".format(totalPrice)}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }

            // Lista de productos en el carrito
            LazyColumn(
                modifier = Modifier
                    .weight(1f) // Hace que la lista ocupe el espacio restante
                    .padding(16.dp)
            ) {
                items(cartItems) { product ->
                    CartItemCard(product = product, onRemove = {
                        cartViewModel.removeFromCart(product)
                    })
                }
            }

            // Botón para limpiar el carrito
            Button(
                onClick = { cartViewModel.clearCart() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Limpiar Carrito")
            }
        }
    }
}
