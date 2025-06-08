package com.example.polis_app

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class AddCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        val nameEdit = findViewById<EditText>(R.id.editTextName)
        val descEdit = findViewById<EditText>(R.id.editTextDescription)
        val saveButton = findViewById<Button>(R.id.buttonSave)

        saveButton.setOnClickListener {
            val name = nameEdit.text.toString()
            val description = descEdit.text.toString()
            val result = Intent().apply {
                putExtra("name", name)
                putExtra("description", description)
            }
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}