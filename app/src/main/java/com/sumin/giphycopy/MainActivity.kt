package com.sumin.giphycopy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sumin.giphycopy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView  = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.trendingFragment,
            R.id.userFragment
        ))
        navView.setupWithNavController(navController)
    }
}