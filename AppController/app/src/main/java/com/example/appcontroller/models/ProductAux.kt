package com.example.appcontroller.models

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcontroller.R
import java.io.Serializable

class ProductAux(
    var name: String, var price: Double, var quant: Int, var discount: Double
) : Serializable

class ProductCarouselAdapter(private val productsAux: List<ProductAux>) : RecyclerView.Adapter<ProductCarouselAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productsAux[position])
    }

    override fun getItemCount(): Int = productsAux.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private val quantityTextView: TextView = itemView.findViewById(R.id.quantity_text_view)
        private val priceTextView: TextView = itemView.findViewById(R.id.price_text_view)
        private val  discountTextView: TextView = itemView.findViewById(R.id.discount_text_view)
        @SuppressLint("SetTextI18n")
        fun bind(productAux: ProductAux) {
            nameTextView.text = productAux.name
            quantityTextView.text = "Quantidade: ${productAux.quant}"
            priceTextView.text = "Valor: R$ ${productAux.price}"
            discountTextView.text = "Desconto: R$ ${productAux.discount}"
        }
    }
}

