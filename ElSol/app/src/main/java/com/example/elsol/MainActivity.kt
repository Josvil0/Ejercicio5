package com.example.elsol

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        // Crear una lista de imágenes solares
        val solarList = mutableListOf(
            SolarItem("corona solar", R.drawable.corona_solar),
            SolarItem("erupcion solar", R.drawable.erupcionsolar),
            SolarItem("espiculas", R.drawable.espiculas),
            SolarItem("filamentos",R.drawable.filamentos ),
            SolarItem("magnetosfera",R.drawable.magnetosfera ),
            SolarItem("mancha solar",R.drawable.manchasolar)


        )


        recyclerView.adapter = SolarAdapter(solarList)
    }


}
