package com.example.polis_app

class CourseRepository(private val apiService: ApiService) {
    suspend fun getCourses(): List<Course> {
        return apiService.getCourses(CourseRequest())
    }

    suspend fun addCourse(course: Course): Course {
        return apiService.addCourse(course)
    }
}