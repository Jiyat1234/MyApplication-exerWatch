package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExerciseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_detail)

        val tvName: TextView = findViewById(R.id.tvExerciseName)
        val ivImage: ImageView = findViewById(R.id.ivExerciseImage)
        val tvReps: TextView = findViewById(R.id.tvExerciseReps)

        val name = intent.getStringExtra("exerciseName")
        val image = intent.getIntExtra("exerciseImage", 0)
        val maxReps = intent.getIntExtra("maxReps", 0)

        tvName.text = name
        ivImage.setImageResource(image)
        tvReps.text = "Reps: 0/$maxReps"
    }
}
