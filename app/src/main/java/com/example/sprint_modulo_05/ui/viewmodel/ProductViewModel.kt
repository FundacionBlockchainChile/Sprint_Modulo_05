package com.example.sprint_modulo_05.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sprint_modulo_05.data.ProductRepository
import com.example.sprint_modulo_05.model.Product

class ProductViewModel : ViewModel() {
    private val productRepository = ProductRepository()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    init {
        loadProducts()
    }

    private fun loadProducts() {
        _products.value = productRepository.getProducts()
    }
}