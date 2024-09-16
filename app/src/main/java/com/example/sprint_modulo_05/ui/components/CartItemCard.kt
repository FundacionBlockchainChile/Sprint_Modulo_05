package com.example.sprint_modulo_05.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sprint_modulo_05.model.Product

@Composable
fun CartItemCard(
    product: Product,
    onRemove: () -> Unit
) {
    // Usamos la Card de Material 3
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        // Usamos shadowElevation en Material 3
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            IconButton(onClick = onRemove) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_delete),
                    contentDescription = "Eliminar del carrito"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemCardPreview() {
    val product = Product(
        id = 1,
        name = "Zapato Formal",
        image = android.R.drawable.ic_menu_camera,  // Un recurso temporal para la previsualización
        price = 60.0,
        sizes = listOf(38, 39, 40),
        colors = listOf("Negro", "Café")
    )
    CartItemCard(product = product, onRemove = {})
}
