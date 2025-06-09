package com.example.polis_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddCourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)

        val nameEdit = findViewById<EditText>(R.id.editTextName)
        val descEdit = findViewById<EditText>(R.id.editTextDescription)
        val saveButton = findViewById<Button>(R.id.buttonSave)

        // when save button is clicked
        saveButton.setOnClickListener {
            val name = nameEdit.text.toString().trim()
            val description = descEdit.text.toString().trim()

            if (name.isNotEmpty()) {
                // prepare intent with entered data
                val result = Intent().apply {
                    putExtra("name", name)
                    putExtra("description", description)
                }
                // return result to calling activity
                setResult(Activity.RESULT_OK, result)
                finish()
            } else {
                // show error if name is empty
                nameEdit.error = "Please enter the course name"
            }
        }
    }
}
