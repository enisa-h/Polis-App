package com.example.polis_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val courses = mutableListOf<Course>()
    private lateinit var adapter: CourseAdapter

    // ✅ API moderne për rezultate nga aktivitete
    private val addCourseLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val name = data?.getStringExtra("name") ?: return@registerForActivityResult
            val description = data.getStringExtra("description") ?: ""
            courses.add(Course(name = name, description = description))
            adapter.notifyItemInserted(courses.size - 1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CourseAdapter(courses)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // ✅ Përdorimi i launcher-it të ri, pa startActivityForResult
        findViewById<Button>(R.id.addButton).setOnClickListener {
            val intent = Intent(this, AddCourseActivity::class.java)
            addCourseLauncher.launch(intent)
        }
    }
}
