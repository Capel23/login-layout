package com.example.loginlayout

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var cartBadge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el email del usuario
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: "Usuario"
        val welcomeTextView = findViewById<TextView>(R.id.welcomeText)
        welcomeTextView.text = "¡Bienvenido!\n$userEmail"

        // Inicializar el badge del carrito
        cartBadge = findViewById(R.id.cartBadge)

        // Botón de cerrar sesión
        val logoutButton = findViewById<ImageButton>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            // Limpiar carrito al cerrar sesión
            CartManager.clearCart()
            // Volver a la actividad de login
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Botón de carrito (usar el contenedor para mejor área de click)
        val cartButtonContainer = findViewById<FrameLayout>(R.id.cartButtonContainer)
        cartButtonContainer.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        // Configurar RecyclerView con productos
        val productsRecyclerView = findViewById<RecyclerView>(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager = GridLayoutManager(this, 2)

        // Usar la lista de productos del modelo Product
        val products = Product.getSampleProducts()

        val adapter = ProductAdapter(products)
        productsRecyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateCartBadge()
    }

    private fun updateCartBadge() {
        val itemCount = CartManager.getItemCount()
        if (itemCount > 0) {
            cartBadge.visibility = View.VISIBLE
            cartBadge.text = if (itemCount > 99) "99+" else itemCount.toString()
        } else {
            cartBadge.visibility = View.GONE
        }
    }
}
