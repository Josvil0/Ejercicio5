package com.example.coffeeshops

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoffeeShopAdapter(
    private val coffeeShops: List<CoffeeShop>,
    private val onReserveClicked: (CoffeeShop) -> Unit
) : RecyclerView.Adapter<CoffeeShopAdapter.CoffeeShopViewHolder>() {

    inner class CoffeeShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coffeeShopImage: ImageView = itemView.findViewById(R.id.coffeeShopImage)
        val coffeeShopTitle: TextView = itemView.findViewById(R.id.coffeeShopTitle)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val coffeeShopAddress: TextView = itemView.findViewById(R.id.coffeeShopAddress)
        val reserveButton: Button = itemView.findViewById(R.id.reserveButton)

        fun bind(coffeeShop: CoffeeShop) {
            coffeeShopImage.setImageResource(coffeeShop.imageResId)
            coffeeShopTitle.text = coffeeShop.name
            ratingBar.rating = coffeeShop.rating
            coffeeShopAddress.text = coffeeShop.address

            reserveButton.setOnClickListener {
                onReserveClicked(coffeeShop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coffee_shop, parent, false)
        return CoffeeShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeShopViewHolder, position: Int) {
        holder.bind(coffeeShops[position])
    }

    override fun getItemCount(): Int {
        return coffeeShops.size
    }
}
