package com.example.loginlayout

import java.io.Serializable
import java.util.Locale

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageRes: Int
) : Serializable {

    // Formatea el precio como String
    fun getFormattedPrice(): String = "\$${String.format(Locale.US, "%.2f", price)}"

    companion object {
        // Lista de productos del ecommerce MANGUP
        fun getSampleProducts(): List<Product> = listOf(
            Product(
                id = 1,
                name = "Camiseta MANGUP",
                price = 19.99,
                description = "Camiseta de algodón 100% con el logo exclusivo de MANGUP. Disponible en varias tallas. Material suave y cómodo para el uso diario.",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 2,
                name = "Gorra MANGUP",
                price = 14.99,
                description = "Gorra ajustable con el icónico gato de la suerte MANGUP bordado. Perfecta para protegerte del sol con estilo.",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 3,
                name = "Sudadera MANGUP",
                price = 49.99,
                description = "Sudadera premium con capucha. Interior afelpado para máxima comodidad. Logo MANGUP estampado en el pecho.",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 4,
                name = "Botella Térmica",
                price = 24.99,
                description = "Botella térmica de acero inoxidable con diseño MANGUP. Mantiene tus bebidas frías 24h o calientes 12h. Capacidad 500ml.",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 5,
                name = "Mochila Premium",
                price = 59.99,
                description = "Mochila resistente al agua con múltiples compartimentos. Diseño ergonómico y bolsillo acolchado para laptop hasta 15\".",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 6,
                name = "Calcetines Pack",
                price = 12.99,
                description = "Pack de 3 pares de calcetines con diferentes diseños MANGUP. Material transpirable y cómodo.",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 7,
                name = "Funda para Celular",
                price = 15.99,
                description = "Funda protectora con el diseño del gato MANGUP. Compatible con la mayoría de modelos. Protección contra golpes.",
                imageRes = R.drawable.ic_launcher_background
            ),
            Product(
                id = 8,
                name = "Poster MANGUP",
                price = 9.99,
                description = "Poster decorativo de alta calidad con el arte del gato de la suerte MANGUP. Tamaño A3 (29.7 x 42 cm).",
                imageRes = R.drawable.ic_launcher_background
            )
        )
    }
}

