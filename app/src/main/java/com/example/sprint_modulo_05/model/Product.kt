package com.example.sprint_modulo_05.model

data class Product(
    val id: Int,
    val name: String,
    val image: Int,  // Puede ser un drawable o una URL dependiendo de la implementación
    val price: Double,
    val sizes: List<Int>,
    val colors: List<String>
)