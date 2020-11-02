package com.furkansubasiay.bottomnavigationwithfab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavView.background=null

        fab.setOnClickListener {
            Toast.makeText(applicationContext,"Call",Toast.LENGTH_LONG).show()
        }

       supportFragmentManager.beginTransaction().replace(R.id.container,  HomeFragment(),  HomeFragment().javaClass.getSimpleName())
            .commit()

        bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuHome -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment(), HomeFragment().javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuSearch -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment(), SearchFragment().javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuProfile ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment(), ProfileFragment().javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuSettings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment(), SettingsFragment().javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
           return@setOnNavigationItemSelectedListener false
        }
    }
}
