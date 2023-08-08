package com.spring.boot.rest.api.controller;

import com.spring.boot.rest.api.entity.Course;
import com.spring.boot.rest.api.service.CourseServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseServiceImpl courseService;

    /**
     * Get all courses
     *
     * @return ResponseEntity containing a list of all courses
     */
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        logger.info("Fetching all courses");
        List<Course> allCourses = courseService.getAllCourses();
        logger.info("Returning {} courses", allCourses.size());
        return ResponseEntity.ok(allCourses);
    }

    /**
     * Get a course by ID.
     *
     * @param id ID of the course.
     * @return ResponseEntity containing the requested course or null.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        logger.info("Fetching course by ID : {}", id);
        Course requiredCourse = courseService.getCourseById(id);
        if (requiredCourse == null) {
            logger.warn("Course not found with ID : {}", id);
            return ResponseEntity.notFound().build();
        }
        logger.info("Returning course with ID : {}", id);
        return ResponseEntity.ok(requiredCourse);
    }

    /**
     * Add a new course.
     *
     * @param course Course object to be added.
     * @return ResponseEntity containing the added course.
     */
    @PostMapping
    public ResponseEntity<Course> addNewCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
        logger.info("Course added successfully");
        return ResponseEntity.ok(course);
    }

    /**
     * Update existing course.
     *
     * @param updatedCourse updated course object.
     * @return ResponseEntity containing updated course.
     */
    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course updatedCourse) {
        Long id = updatedCourse.getCourseId();
        logger.info("Updating course with ID: {}", id);
        Course course = courseService.updateCourse(id, updatedCourse);
        logger.info("Course updated successfully");
        return ResponseEntity.ok(course);
    }

    /**
     * Delete course by ID.
     *
     * @param id ID of the course.
     * @return ResponseEntity containing a deletion message and HTTP status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable String id) {
        logger.info("Deleting course with ID : {}", Long.parseLong(id));
        String status = courseService.deleteCourseById(Long.parseLong(id));
        logger.info("Course deleted successfully.");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
