package com.example.sprint_modulo_05.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint_modulo_05.data.DataStoreManager
import com.example.sprint_modulo_05.model.Product
import kotlinx.coroutines.launch

class CartViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {

    private val _cartItems = MutableLiveData<List<Product>>()
    val cartItems: LiveData<List<Product>> = _cartItems

    init {
        viewModelScope.launch {
            dataStoreManager.cartProducts.collect {
                _cartItems.value = it
            }
        }
    }

    fun addToCart(product: Product) {
        val currentCart = _cartItems.value ?: emptyList()
        val updatedCart = currentCart + product
        viewModelScope.launch {
            dataStoreManager.saveCartProducts(updatedCart)
        }
    }

    fun removeFromCart(product: Product) {
        val currentCart = _cartItems.value ?: emptyList()
        val updatedCart = currentCart - product
        viewModelScope.launch {
            dataStoreManager.saveCartProducts(updatedCart)
        }
    }

    fun clearCart() {
        viewModelScope.launch {
            dataStoreManager.saveCartProducts(emptyList())
        }
    }
}
