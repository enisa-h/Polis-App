package com.example.polis_app

class CourseRepository(private val apiService: ApiService) {

    // fetches the list of courses from the API
    suspend fun getCourses(): List<Course> {
        return apiService.getCourses(CourseRequest())
    }

    // adds a new course via the API
    suspend fun addCourse(course: Course): Course {
        return apiService.addCourse(course)
    }
}
