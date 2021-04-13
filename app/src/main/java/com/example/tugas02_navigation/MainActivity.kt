package com.example.tugas02_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.tugas02_navigation.adapter.view_page
import com.example.tugas02_navigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toogle : ActionBarDrawerToggle
    private lateinit var home : fragment_home1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bottom = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        var container = findViewById<FrameLayout>(R.id.container)

        home = fragment_home1()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container,home)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home1 -> fragmentTransaction(fragment_home1())
                R.id.searh -> fragmentTransaction(fragment_search())
            }
            true
        }

        toogle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.drawerView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.chat -> Toast.makeText(this, "CHAT", Toast.LENGTH_SHORT).show()
                R.id.call -> Toast.makeText(this, "CALL", Toast.LENGTH_SHORT).show()
                R.id.rej-> Toast.makeText(this, "REJECTED CALL", Toast.LENGTH_SHORT).show()
                R.id.acun -> Toast.makeText(this, "ACCOUNT", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}