package com.example.polis_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData

class CourseViewModel(private val repository: CourseRepository) : ViewModel() {
    private val courses = MutableLiveData<List<Course>>()
    private val error = MutableLiveData<String>()

    private fun fetchCourses() {
        viewModelScope.launch {
            try {
                courses.value = repository.getCourses()
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }


    fun addCourse(course: Course) {
        viewModelScope.launch {
            try {
                repository.addCourse(course)
                fetchCourses()
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }
}