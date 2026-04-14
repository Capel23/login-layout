package com.example.loginlayout

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            val productImage = itemView.findViewById<ImageView>(R.id.productImage)
            val productName = itemView.findViewById<TextView>(R.id.productName)
            val productPrice = itemView.findViewById<TextView>(R.id.productPrice)

            productImage.setImageResource(product.imageRes)
            productName.text = product.name
            productPrice.text = product.getFormattedPrice()

            // Hacer clickeable el producto
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, ProductDetailActivity::class.java)
                intent.putExtra("PRODUCT", product as java.io.Serializable)
                context.startActivity(intent)
            }
        }
    }
}
