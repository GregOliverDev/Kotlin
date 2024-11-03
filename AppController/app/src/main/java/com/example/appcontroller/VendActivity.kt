package com.example.appcontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.appcontroller.models.ProductAux
import com.example.appcontroller.models.ProductCarouselAdapter
import com.example.appcontroller.models.User

class VendActivity: ComponentActivity() {
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vend)
        user = (intent.getSerializableExtra("CURRENT_USER") as? User)!!


        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        val viewPagerAdd = findViewById<ViewPager2>(R.id.view_pager_add)

        val products = listOf(
            ProductAux( "Produto 1", 10.50, 99, 5.41),
            ProductAux( "Produto 2", 5.99, 149, 1.25),
            ProductAux( "Produto 3", 3.22, 79, 0.00)
        )
        viewPager.adapter = ProductCarouselAdapter(products)
        viewPagerAdd.adapter = ProductCarouselAdapter(products)
    }
}

