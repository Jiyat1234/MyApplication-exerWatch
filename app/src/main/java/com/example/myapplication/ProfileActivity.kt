package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etDOB: EditText
    private lateinit var etEmail: EditText
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var etGender: EditText
    private lateinit var btnEdit: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize views
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etDOB = findViewById(R.id.etDOB)
        etEmail = findViewById(R.id.etEmail)
        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        etGender = findViewById(R.id.etGender)
        btnEdit = findViewById(R.id.btnEditProfile)
        btnSave = findViewById(R.id.btnSaveProfile)

        // Fill default static data
        etName.setText("John Doe")
        etAge.setText("28")
        etDOB.setText("01/01/1995")
        etEmail.setText("john@example.com")
        etHeight.setText("175 cm")
        etWeight.setText("70 kg")
        etGender.setText("Male")

        // Button click listeners
        btnEdit.setOnClickListener { enableEditing(true) }
        btnSave.setOnClickListener {
            enableEditing(false)
            Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show()
        }
    }

    private fun enableEditing(enable: Boolean) {
        etName.isEnabled = enable
        etAge.isEnabled = enable
        etDOB.isEnabled = enable
        etEmail.isEnabled = enable
        etHeight.isEnabled = enable
        etWeight.isEnabled = enable
        etGender.isEnabled = enable

        btnEdit.visibility = if (enable) Button.GONE else Button.VISIBLE
        btnSave.visibility = if (enable) Button.VISIBLE else Button.GONE
    }

    // Toolbar back button
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
