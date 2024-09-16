package com.example.sprint_modulo_05.data

import com.example.sprint_modulo_05.R
import com.example.sprint_modulo_05.model.Product

class ProductRepository {
    fun getProducts(): List<Product> {
        return listOf(
            // Zapatos
            Product(
                id = 1,
                name = "Zapato Formal 1",
                image = R.drawable.zapato_01,
                price = 50.0,
                sizes = listOf(38, 39, 40),
                colors = listOf("Negro", "Café")
            ),
            Product(
                id = 2,
                name = "Zapato Formal 2",
                image = R.drawable.zapato_02,
                price = 55.0,
                sizes = listOf(39, 40, 41),
                colors = listOf("Negro", "Gris")
            ),
            Product(
                id = 3,
                name = "Zapato Formal 3",
                image = R.drawable.zapato_03,
                price = 60.0,
                sizes = listOf(40, 41, 42),
                colors = listOf("Marrón", "Negro")
            ),
            Product(
                id = 4,
                name = "Zapato Formal 4",
                image = R.drawable.zapato_04,
                price = 65.0,
                sizes = listOf(41, 42, 43),
                colors = listOf("Negro", "Café Oscuro")
            ),
            Product(
                id = 5,
                name = "Zapato Formal 5",
                image = R.drawable.zapato_05,
                price = 70.0,
                sizes = listOf(42, 43, 44),
                colors = listOf("Negro", "Gris Oscuro")
            ),
            Product(
                id = 6,
                name = "Zapato Formal 6",
                image = R.drawable.zapato_06,
                price = 75.0,
                sizes = listOf(43, 44, 45),
                colors = listOf("Negro", "Café Claro")
            ),

            // Zapatillas
            Product(
                id = 7,
                name = "Zapatilla Deportiva 1",
                image = R.drawable.zapatilla_01,
                price = 80.0,
                sizes = listOf(38, 39, 40),
                colors = listOf("Blanco", "Azul")
            ),
            Product(
                id = 8,
                name = "Zapatilla Deportiva 2",
                image = R.drawable.zapatilla_02,
                price = 85.0,
                sizes = listOf(39, 40, 41),
                colors = listOf("Negro", "Rojo")
            ),
            Product(
                id = 9,
                name = "Zapatilla Deportiva 3",
                image = R.drawable.zapatilla_03,
                price = 90.0,
                sizes = listOf(40, 41, 42),
                colors = listOf("Blanco", "Negro")
            ),
            Product(
                id = 10,
                name = "Zapatilla Deportiva 4",
                image = R.drawable.zapatilla_04,
                price = 95.0,
                sizes = listOf(41, 42, 43),
                colors = listOf("Gris", "Negro")
            ),
            Product(
                id = 11,
                name = "Zapatilla Deportiva 5",
                image = R.drawable.zapatilla_05,
                price = 100.0,
                sizes = listOf(42, 43, 44),
                colors = listOf("Verde", "Blanco")
            ),
            Product(
                id = 12,
                name = "Zapatilla Deportiva 6",
                image = R.drawable.zapatilla_06,
                price = 105.0,
                sizes = listOf(43, 44, 45),
                colors = listOf("Azul", "Gris")
            ),
            Product(
                id = 13,
                name = "Zapatilla Deportiva 7",
                image = R.drawable.zapatilla_07,
                price = 110.0,
                sizes = listOf(44, 45, 46),
                colors = listOf("Negro", "Blanco")
            )
        )
    }
}