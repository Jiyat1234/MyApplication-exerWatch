package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class DashboardFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var btnStartExercise: Button
    private lateinit var tvWelcome: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // DrawerLayout and NavigationView
        drawerLayout = view.findViewById(R.id.drawer_layout)
        navView = view.findViewById(R.id.navView)

        // Toolbar
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as? androidx.appcompat.app.AppCompatActivity)?.setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            activity,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Views
        btnStartExercise = view.findViewById(R.id.btnStartExercise)
        tvWelcome = view.findViewById(R.id.tvWelcome)

        tvWelcome.text = "Welcome, User!"

        // Navigation menu clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> {
                    startActivity(Intent(activity, ProfileActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(activity, SettingsActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_exercise -> {
                    startActivity(Intent(activity, ExerciseActivity::class.java))
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_logout -> {
                    drawerLayout.closeDrawers()
                    activity?.finish()
                    true
                }
                else -> false
            }
        }

        // Start Exercise button
        btnStartExercise.setOnClickListener {
            startActivity(Intent(activity, ExerciseActivity::class.java))
        }

        return view
    }
}
