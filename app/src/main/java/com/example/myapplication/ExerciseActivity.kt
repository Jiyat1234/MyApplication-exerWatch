package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val exercises = listOf(
            Exercise("Shoulder Rotation", R.drawable.ic_shoulder, 10),
            Exercise("Arm Stretch", R.drawable.ic_arm, 15),
            Exercise("Leg Raises", R.drawable.ic_leg, 12),
            Exercise("Neck Stretch", R.drawable.ic_neck, 8),
            Exercise("Squats", R.drawable.ic_squat, 20)
        )

        val rvExercises: RecyclerView = findViewById(R.id.rvExercises)
        rvExercises.layoutManager = LinearLayoutManager(this)
        rvExercises.adapter = ExerciseAdapter(exercises) { exercise ->
            val intent = Intent(this, ExerciseDetailActivity::class.java)
            intent.putExtra("exerciseName", exercise.name)
            intent.putExtra("exerciseImage", exercise.imageRes)
            intent.putExtra("maxReps", exercise.maxReps)
            startActivity(intent)
        }
    }
}
