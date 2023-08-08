package com.spring.boot.rest.api.service;

import com.spring.boot.rest.api.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    void addNewCourse(Course course);

    Course updateCourse(Long id, Course updatedCourse);

    String deleteCourseById(Long id);
}
