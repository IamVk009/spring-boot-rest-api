package com.spring.boot.rest.api.service;

import com.spring.boot.rest.api.dao.CourseRepository;
import com.spring.boot.rest.api.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseRepository courseRepository;

//    After connecting to DB, this list of courses is not required as we are directly storing the new course details into a DB.
//    List<Course> courses = new ArrayList<Course>();

    /**
     * Get a list of all courses.
     *
     * @return List of all courses.
     */
    @Override
    public List<Course> getAllCourses() {

//      return courses;

//      After connecting to DB
        return courseRepository.findAll();
    }

    /**
     * Get a course by its ID.
     *
     * @param id ID of the course.
     * @return Course object if found, otherwise null.
     */
    @Override
    public Course getCourseById(Long id) {

//      Way - 1 : Using filter method of StreamAPI
//      List<Course> course = courses.stream().filter(item -> item.getCourseId() == id).collect(Collectors.toList());
//      return course.get(0);

//      Way - 2 : Using for-each loop on courses list.
//        Course requiredCourse = null;
//        for (Course course : courses) {
//            if (course.getCourseId() == id) {
//                requiredCourse = course;
//                break;
//            }
//        }
//        return requiredCourse;

//        After connecting to DB;
        return courseRepository.findById(id).orElse(null);

    }

    /**
     * Add a new course.
     *
     * @param course Newly added Course Object.
     */
    @Override
    public void addNewCourse(Course course) {

//      courses.add(course);
//      return course.getCourseId();

//      After connecting to DB
        courseRepository.save(course);
    }

    /**
     * Update existing course
     *
     * @param id            ID of the course to be updated.
     * @param updatedCourse Updated course object.
     * @return Updated course object.
     */
    @Override
    public Course updateCourse(Long id, Course updatedCourse) {
//        Way - 1 : Using For-Each Loop
//        for (Course course : courses) {
//            if (course.getCourseId().equals(id)) {
//                course.setCourseName(updatedCourse.getCourseName());
//                course.setDescription(updatedCourse.getDescription());
//            }
//        }
//        return updatedCourse;

//        Way - 2 : Using Lambda Function forEach Method.
//        courses.forEach(i -> {
//            if (i.getCourseId() == updatedCourse.getCourseId()) {
//                i.setCourseName(updatedCourse.getCourseName());
//                i.setDescription(updatedCourse.getDescription());
//            }
//        });
//
//        return updatedCourse;

//      After Connecting to DB
//      Way - 1
//        Course existingCourse = courseRepository.findById(id).orElse(null);
//        logger.info("existingCourse = " + existingCourse);
//        if (existingCourse != null) {
//            existingCourse.setCourseName(updatedCourse.getCourseName());
//            existingCourse.setDescription(updatedCourse.getDescription());
//            courseRepository.save(existingCourse);
//        }
//        return updatedCourse;

//      Way - 2
        courseRepository.save(updatedCourse);
        return updatedCourse;
    }

    /**
     * Delete a course by its ID.
     *
     * @param id ID of the course to be deleted.
     * @return Deletion status message.
     */
    @Override
    public String deleteCourseById(Long id) {

//      Way - 1 : Using filter method of Stream API.
//      List<Course> course = courses.stream().filter(item -> item.getCourseId() == id).collect(Collectors.toList());
//      courses.remove(course.get(0));

//        Way - 2 : Using for-each loop on list of courses.
//        Course requiredCourse = null;
//        for (Course course : courses) {
//            if (course.getCourseId() == id) {
//                requiredCourse = course;
//                courses.remove(course);
//                break;
//            }
//        }

//      After connecting to DB
        courseRepository.deleteById(id);
        return "Course with Id = " + id + " was deleted successfully.";
    }
}
