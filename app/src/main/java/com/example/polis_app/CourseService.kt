package com.example.polis_app
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
interface CourseService {
    @GET("/courses")
    suspend fun getCourses(): List<Course>

    @POST("/courses")
    suspend fun addCourse(@Body course: Course)
}