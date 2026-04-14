package com.example.loginlayout

import java.util.Locale

object CartManager {
    
    private val cartItems = mutableMapOf<Int, CartItem>()
    
    data class CartItem(
        val product: Product,
        var quantity: Int
    ) {
        fun getTotalPrice(): Double = product.price * quantity
        fun getFormattedTotalPrice(): String = "\$${String.format(Locale.US, "%.2f", getTotalPrice())}"
    }
    
    fun addProduct(product: Product, quantity: Int = 1) {
        val existingItem = cartItems[product.id]
        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            cartItems[product.id] = CartItem(product, quantity)
        }
    }
    
    fun removeProduct(productId: Int) {
        cartItems.remove(productId)
    }
    
    fun decreaseQuantity(productId: Int) {
        val item = cartItems[productId]
        if (item != null) {
            if (item.quantity > 1) {
                item.quantity--
            } else {
                cartItems.remove(productId)
            }
        }
    }
    
    fun increaseQuantity(productId: Int) {
        val item = cartItems[productId]
        if (item != null) {
            item.quantity = item.quantity + 1
        }
    }
    
    fun getCartItems(): List<CartItem> = cartItems.values.toList()
    
    fun getItemCount(): Int = cartItems.values.sumOf { it.quantity }
    
    fun getTotalPrice(): Double = cartItems.values.sumOf { it.getTotalPrice() }
    
    fun getFormattedTotalPrice(): String = "\$${String.format(Locale.US, "%.2f", getTotalPrice())}"
    
    fun clearCart() {
        cartItems.clear()
    }
    
    fun isEmpty(): Boolean = cartItems.isEmpty()
    
    fun isInCart(productId: Int): Boolean = cartItems.containsKey(productId)
    
    fun getQuantity(productId: Int): Int = cartItems[productId]?.quantity ?: 0
}
