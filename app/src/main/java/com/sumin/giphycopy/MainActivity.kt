package com.sumin.giphycopy

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setBackgroundColor(Color.BLACK)
        val navController = findNavController(R.id.nav_host)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.trendingFragment,
            R.id.userFragment
        ))
        navView.setupWithNavController(navController)
    }
}