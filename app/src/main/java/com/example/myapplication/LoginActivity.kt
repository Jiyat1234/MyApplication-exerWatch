package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_login)

        // Match IDs from activity_login.xml
        val btnPatient = findViewById<Button>(R.id.btn_patient_login)
        val btnPractitioner = findViewById<Button>(R.id.btn_practitioner)

        btnPatient.setOnClickListener {
            showPatientLoginDialog()
        }

        btnPractitioner.setOnClickListener {
            Toast.makeText(this, "Practitioner login coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showPatientLoginDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Patient Login")
        val view = layoutInflater.inflate(R.layout.dialog_login_patient, null)

        val etId = view.findViewById<EditText>(R.id.et_patient_id)
        val etPass = view.findViewById<EditText>(R.id.et_patient_password)
        builder.setView(view)

        builder.setPositiveButton("Login") { _, _ ->
            val id = etId.text.toString().trim()
            val pass = etPass.text.toString().trim()

            // Static check for demo
            if (id == "patient01" && pass == "1234") {
                startActivity(Intent(this, PatientDashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid ID or Password", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancel", null)
        builder.show()
    }
}
