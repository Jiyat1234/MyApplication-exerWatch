package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PatientLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_login)

        val btnPatient: Button = findViewById(R.id.btn_patient_login)
        val btnPractitioner: Button = findViewById(R.id.btn_practitioner)

        btnPatient.setOnClickListener {
            showPatientLoginDialog()
        }

        btnPractitioner.setOnClickListener {
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showPatientLoginDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Patient Login")

        val view = layoutInflater.inflate(R.layout.dialog_login_patient, null)
        val etEmail = view.findViewById<EditText>(R.id.et_patient_id)
        val etPassword = view.findViewById<EditText>(R.id.et_patient_password)

        builder.setView(view)
        builder.setPositiveButton("Login") { dialog, _ ->
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            // For now, just show a toast
            Toast.makeText(this, "Email: $email\nPassword: $password", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }
}
