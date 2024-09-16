package com.example.sprint_modulo_05.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sprint_modulo_05.ui.components.AppTopBar
import com.example.sprint_modulo_05.ui.viewmodel.CartViewModel
import com.example.sprint_modulo_05.ui.viewmodel.ProductViewModel
import kotlinx.coroutines.launch

@Composable
fun ProductDetailScreen(
    productId: Int,
    productViewModel: ProductViewModel,
    cartViewModel: CartViewModel,
    navController: NavController
) {
    val product = productViewModel.products.value?.find { it.id == productId }

    // Estado para manejar la visibilidad de la Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AppTopBar(
                navController = navController,
                title = product?.name ?: "Detalles",
                showBackButton = true,
                onCartClick = { navController.navigate("cart") }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        product?.let {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagen del producto
                Image(
                    painter = painterResource(id = it.image),
                    contentDescription = it.name,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(24.dp))

                // Nombre del producto
                Text(
                    text = it.name,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 28.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )

                // Precio del producto
                Text(
                    text = "Precio: $${it.price}",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier.padding(8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botón para agregar al carrito
                Button(
                    onClick = {
                        cartViewModel.addToCart(it)
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(
                                message = "${it.name} agregado al carrito",
                                duration = SnackbarDuration.Short
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "Agregar al carrito", fontSize = 16.sp)
                }
            }
        }
    }
}
