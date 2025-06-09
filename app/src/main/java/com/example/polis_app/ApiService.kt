package com.example.polis_app

import retrofit2.http.Body
import retrofit2.http.POST

// data class for course request filters
data class CourseRequest(val filter: String? = null)

interface ApiService {
    // POST request to fetch courses, optionally with filter criteria
    @POST("courses")
    suspend fun getCourses(@Body request: CourseRequest = CourseRequest()): List<Course>

    // POST request to add a new course
    @POST("courses/add")
    suspend fun addCourse(@Body course: Course): Course
}
