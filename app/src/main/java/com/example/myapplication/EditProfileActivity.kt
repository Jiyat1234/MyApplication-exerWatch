package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var nameEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var ageEdit: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        nameEdit = findViewById(R.id.editName)
        emailEdit = findViewById(R.id.editEmail)
        ageEdit = findViewById(R.id.editAge)
        saveButton = findViewById(R.id.btnSave)

        // Pre-fill existing data if sent from ProfileFragment
        intent.extras?.let {
            nameEdit.setText(it.getString("name", ""))
            emailEdit.setText(it.getString("email", ""))
            ageEdit.setText(it.getString("age", ""))
        }

        saveButton.setOnClickListener {
            val name = nameEdit.text.toString()
            val email = emailEdit.text.toString()
            val age = ageEdit.text.toString()

            if (name.isEmpty() || email.isEmpty() || age.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Send updated values back to ProfileFragment
                val resultIntent = Intent().apply {
                    putExtra("name", name)
                    putExtra("email", email)
                    putExtra("age", age)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()
                finish() // go back to ProfileFragment
            }
        }
    }
}
