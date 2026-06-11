package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class PatientDashboardActivity : AppCompatActivity() {

    private lateinit var drawer_layout: DrawerLayout
    private lateinit var navView: NavigationView

    private lateinit var exerciseProgressBar: ProgressBar
    private lateinit var tvExerciseProgress: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_dashboard)

        drawer_layout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.navView)

        // Toolbar toggle
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.open_drawer, R.string.close_drawer
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        // Exercise progress views
        exerciseProgressBar = findViewById(R.id.exerciseProgressBar)
        tvExerciseProgress = findViewById(R.id.tvExerciseProgress)

        // Example: total exercises = 10, completed = 4
        val totalExercises = 10
        val completedExercises = intent.getIntExtra("completedExercises", 0) // dynamic if passed
        val progressPercent = (completedExercises * 100) / totalExercises
        exerciseProgressBar.progress = progressPercent
        tvExerciseProgress.text = "$progressPercent% completed"

        // Navigation drawer item clicks
        navView.setNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    drawer_layout.closeDrawers()
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    drawer_layout.closeDrawers()
                    true
                }
                R.id.nav_exercise -> {
                    startActivity(Intent(this, ExerciseActivity::class.java))
                    drawer_layout.closeDrawers()
                    true
                }
                R.id.nav_logout -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    drawer_layout.closeDrawers()
                    finish()
                    true
                }
                else -> false
            }
        }

        // Start Exercise button
        findViewById<Button>(R.id.btnStartExercise).setOnClickListener {
            startActivity(Intent(this, ExerciseActivity::class.java))
        }
    }
}
