package com.example.sprint_modulo_05.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sprint_modulo_05.ui.components.AppTopBar
import com.example.sprint_modulo_05.ui.components.ProductCard
import com.example.sprint_modulo_05.ui.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(navController: NavController, productViewModel: ProductViewModel) {
    val products = productViewModel.products.observeAsState(emptyList())

    // Dividimos los productos en dos listas: Zapatos y Zapatillas
    val zapatos = products.value.filter { it.name.contains("Zapato") }
    val zapatillas = products.value.filter { it.name.contains("Zapatilla") }

    Scaffold(
        topBar = {
            AppTopBar(
                navController = navController,
                title = "Productos",
                showBackButton = false, // No hay botón de retroceso en la pantalla inicial
                onCartClick = { navController.navigate("cart") }
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            // Sección de Zapatos
            item {
                Text("Zapatos", style = androidx.compose.material3.MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp))
            }
            item {
                LazyRow {
                    items(zapatos) { product ->
                        ProductCard(product = product) {
                            navController.navigate("product_detail/${product.id}")
                        }
                    }
                }
            }

            // Sección de Zapatillas
            item {
                Text("Zapatillas", style = androidx.compose.material3.MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp))
            }
            item {
                LazyRow {
                    items(zapatillas) { product ->
                        ProductCard(product = product) {
                            navController.navigate("product_detail/${product.id}")
                        }
                    }
                }
            }
        }
    }
}
