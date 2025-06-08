package com.example.polis_app

import retrofit2.http.Body
import retrofit2.http.POST

data class CourseRequest(val filter: String? = null)

interface ApiService {
    @POST("courses")
    suspend fun getCourses(@Body request: CourseRequest = CourseRequest()): List<Course>

    @POST("courses/add")
    suspend fun addCourse(@Body course: Course): Course
}