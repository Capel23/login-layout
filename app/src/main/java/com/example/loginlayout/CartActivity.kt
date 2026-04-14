package com.example.loginlayout

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class CartActivity : AppCompatActivity() {

    private lateinit var adapter: CartAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyCartLayout: LinearLayout
    private lateinit var bottomBar: CardView
    private lateinit var cartItemCount: TextView
    private lateinit var subtotalPrice: TextView
    private lateinit var totalPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupViews()
        setupRecyclerView()
        setupButtons()
        updateUI()
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.cartRecyclerView)
        emptyCartLayout = findViewById(R.id.emptyCartLayout)
        bottomBar = findViewById(R.id.bottomBar)
        cartItemCount = findViewById(R.id.cartItemCount)
        subtotalPrice = findViewById(R.id.subtotalPrice)
        totalPrice = findViewById(R.id.totalPrice)
    }

    private fun setupRecyclerView() {
        adapter = CartAdapter(CartManager.getCartItems()) {
            updateUI()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupButtons() {
        // Botón volver
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            finish()
        }

        // Botón seguir comprando
        findViewById<MaterialButton>(R.id.continueShopping).setOnClickListener {
            finish()
        }

        // Botón checkout
        findViewById<MaterialButton>(R.id.checkoutButton).setOnClickListener {
            if (!CartManager.isEmpty()) {
                Toast.makeText(
                    this,
                    "¡Gracias por tu compra! Total: ${CartManager.getFormattedTotalPrice()}",
                    Toast.LENGTH_LONG
                ).show()
                CartManager.clearCart()
                updateUI()
            }
        }
    }

    private fun updateUI() {
        val items = CartManager.getCartItems()
        adapter.updateItems(items)

        if (CartManager.isEmpty()) {
            recyclerView.visibility = View.GONE
            bottomBar.visibility = View.GONE
            emptyCartLayout.visibility = View.VISIBLE
            cartItemCount.text = "0 items"
        } else {
            recyclerView.visibility = View.VISIBLE
            bottomBar.visibility = View.VISIBLE
            emptyCartLayout.visibility = View.GONE

            val itemCount = CartManager.getItemCount()
            cartItemCount.text = "$itemCount ${if (itemCount == 1) "item" else "items"}"
            subtotalPrice.text = CartManager.getFormattedTotalPrice()
            totalPrice.text = CartManager.getFormattedTotalPrice()
        }
    }
}

