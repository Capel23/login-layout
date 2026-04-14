package com.example.loginlayout

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import java.util.Locale

class ProductDetailActivity : AppCompatActivity() {

    private var quantity = 1
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el producto del intent
        @Suppress("DEPRECATION")
        product = intent.getSerializableExtra("PRODUCT") as? Product ?: run {
            finish()
            return
        }

        setupViews()
        setupQuantitySelector()
        setupButtons()
    }

    private fun setupViews() {
        findViewById<ImageView>(R.id.productImage).setImageResource(product.imageRes)
        findViewById<TextView>(R.id.productName).text = product.name
        findViewById<TextView>(R.id.productPrice).text = product.getFormattedPrice()
        findViewById<TextView>(R.id.productDescription).text = product.description
        updateTotalPrice()
    }

    private fun setupQuantitySelector() {
        val quantityText = findViewById<TextView>(R.id.quantityText)
        val decreaseButton = findViewById<ImageButton>(R.id.decreaseButton)
        val increaseButton = findViewById<ImageButton>(R.id.increaseButton)

        decreaseButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityText.text = quantity.toString()
                updateTotalPrice()
            }
        }

        increaseButton.setOnClickListener {
            if (quantity < 99) {
                quantity++
                quantityText.text = quantity.toString()
                updateTotalPrice()
            }
        }
    }

    private fun updateTotalPrice() {
        val total = product.price * quantity
        findViewById<TextView>(R.id.totalPrice).text = "\$${String.format(Locale.US, "%.2f", total)}"
    }

    private fun setupButtons() {
        // Botón de volver
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

        // Botón del carrito
        findViewById<ImageButton>(R.id.cartButton).setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        // Botón añadir al carrito
        findViewById<MaterialButton>(R.id.addToCartButton).setOnClickListener {
            CartManager.addProduct(product, quantity)
            Toast.makeText(
                this,
                "${product.name} añadido al carrito",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
    }
}

