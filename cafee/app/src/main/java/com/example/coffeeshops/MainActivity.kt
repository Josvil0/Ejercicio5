package com.example.coffeeshops

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val coffeeShops = listOf(
        CoffeeShop(R.drawable.images, "Café Bonito", 4.5f, "Calle de la Esperanza, 123"),
        CoffeeShop(R.drawable.images1, "Café del Mundo", 4.0f, "Avenida Central, 456"),
        CoffeeShop(R.drawable.images2, "Café Arte", 4.8f, "Plaza Mayor, 789"),
        CoffeeShop(R.drawable.images3, "Café Rojo", 4.2f, "Calle del Sol, 101"),
        CoffeeShop(R.drawable.images4, "Café Luna", 4.7f, "Calle de la Luna, 202"),
        CoffeeShop(R.drawable.images5, "Café Rústico", 4.3f, "Calle de la Tierra, 303"),
        CoffeeShop(R.drawable.images6, "Café Sereno", 4.6f, "Calle del Viento, 404")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = CoffeeShopAdapter(coffeeShops) { coffeeShop ->
            Toast.makeText(this, "Reservado en ${coffeeShop.name}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }
}
