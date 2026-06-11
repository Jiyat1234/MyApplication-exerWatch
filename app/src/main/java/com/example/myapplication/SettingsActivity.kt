package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class SettingsActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var etSensorId: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navView)
        etSensorId = findViewById(R.id.et_sensor_id)
        btnSave = findViewById(R.id.btnSaveSettings)

        // Toolbar toggle
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open_drawer, R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Navigation item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    // Open ProfileActivity
                    startActivity(Intent(this, ProfileActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_settings -> {
                    // Already in SettingsActivity
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_exercise -> {
                    startActivity(Intent(this, ExerciseActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_logout -> {
                    drawerLayout.closeDrawers()
                    finish()
                    true
                }
                else -> false
            }
        }

        // Save button
        btnSave.setOnClickListener {
            val sensorId = etSensorId.text.toString().trim()
            if (sensorId.isNotEmpty()) {
                Toast.makeText(this, "Sensor ID saved: $sensorId", Toast.LENGTH_SHORT).show()
                // You can save it in SharedPreferences or backend later
            } else {
                Toast.makeText(this, "Please enter Sensor ID", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
