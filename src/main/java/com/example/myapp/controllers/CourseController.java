package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.repositories.CourseRepository;
import com.example.myapp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CourseController {
  private CourseService courseService;

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return (List<Course>) courseService.findAllCourses();
  }

  @GetMapping("/api/courses/title/{title}")
  public List<Course> findCourseByTitle(@PathVariable("title") String title) {
    return courseService.findCourseByTitle(title);
  }


  @GetMapping("/api/courses/{courseId}")
  public Course findCourseById(@PathVariable("courseId") int courseId) {
    return courseService.findCourseById(courseId);
  }

  @DeleteMapping("/api/courses/{courseId}")
  public List<Course> deleteCourse(@PathVariable("courseId") int courseId) {
    courseService.deleteCourse(courseId);
    return this.findAllCourses();
  }

  @PutMapping("/api/courses/{courseId}")
  public List<Course> updateCourse(@RequestBody Course target, @PathVariable("courseId") int courseId) {
    courseService.updateCourse(target, courseId);
    return this.findAllCourses();
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse(@RequestBody Course course) {
    courseService.createCourse(course);
    return this.findAllCourses();
  }
}
