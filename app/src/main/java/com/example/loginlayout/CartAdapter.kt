package com.example.loginlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private var items: List<CartManager.CartItem>,
    private val onQuantityChanged: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<CartManager.CartItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.cartProductImage)
        private val productName: TextView = itemView.findViewById(R.id.cartProductName)
        private val productPrice: TextView = itemView.findViewById(R.id.cartProductPrice)
        private val quantityText: TextView = itemView.findViewById(R.id.cartQuantityText)
        private val itemTotal: TextView = itemView.findViewById(R.id.cartItemTotal)
        private val decreaseButton: ImageButton = itemView.findViewById(R.id.cartDecreaseButton)
        private val increaseButton: ImageButton = itemView.findViewById(R.id.cartIncreaseButton)
        private val removeButton: ImageButton = itemView.findViewById(R.id.removeButton)

        fun bind(cartItem: CartManager.CartItem) {
            val product = cartItem.product

            productImage.setImageResource(product.imageRes)
            productName.text = product.name
            productPrice.text = product.getFormattedPrice()
            quantityText.text = cartItem.quantity.toString()
            itemTotal.text = cartItem.getFormattedTotalPrice()

            decreaseButton.setOnClickListener {
                CartManager.decreaseQuantity(product.id)
                onQuantityChanged()
            }

            increaseButton.setOnClickListener {
                CartManager.increaseQuantity(product.id)
                onQuantityChanged()
            }

            removeButton.setOnClickListener {
                CartManager.removeProduct(product.id)
                onQuantityChanged()
            }
        }
    }
}

