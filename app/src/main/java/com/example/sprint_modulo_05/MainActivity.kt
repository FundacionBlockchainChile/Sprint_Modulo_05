package com.example.sprint_modulo_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sprint_modulo_05.ui.screens.CartScreen
import com.example.sprint_modulo_05.ui.screens.ProductDetailScreen
import com.example.sprint_modulo_05.ui.screens.ProductListScreen
import com.example.sprint_modulo_05.ui.viewmodel.CartViewModel
import com.example.sprint_modulo_05.ui.viewmodel.ProductViewModel
import  androidx.navigation.compose.NavHost
import com.example.sprint_modulo_05.data.DataStoreManager
import com.example.sprint_modulo_05.ui.viewmodel.CartViewModelFactory

@Composable
fun NavGraph(
    navController: NavHostController,
    productViewModel: ProductViewModel,
    cartViewModel: CartViewModel
) {
    NavHost(navController, startDestination = "product_list") {
        composable("product_list") {
            ProductListScreen(navController, productViewModel)
        }
        composable("product_detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toInt() ?: 0
            ProductDetailScreen(productId, productViewModel, cartViewModel, navController)
        }
        composable("cart") {
            CartScreen(cartViewModel, navController)
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos DataStoreManager
        val dataStoreManager = DataStoreManager(applicationContext)

        setContent {
            val navController = rememberNavController()

            // Inicializamos ProductViewModel sin cambios
            val productViewModel: ProductViewModel = viewModel()

            // Usamos CartViewModelFactory para crear CartViewModel
            val cartViewModel: CartViewModel = viewModel(
                factory = CartViewModelFactory(dataStoreManager)
            )

            // Pasamos los ViewModels a NavGraph
            NavGraph(navController, productViewModel, cartViewModel)
        }
    }
}
