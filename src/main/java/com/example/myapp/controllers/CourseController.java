package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
  @Autowired
  private CourseRepository courseRepo;

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return (List<Course>) courseRepo.findAll();
  }

  @GetMapping("/api/courses/title/{title}")
  public List<Course> findCourseByTitle(@PathVariable("title") String title) {
    return courseRepo.findCourseByTitle(title);
  }


  @GetMapping("/api/courses/{courseId}")
  public Course findCourseById(@PathVariable("courseId") int courseId) {
    Optional<Course> optional = courseRepo.findById(courseId);
    return optional.get();
  }

  @DeleteMapping("/api/courses/{courseId}")
  public List<Course> deleteCourse(@PathVariable("courseId") int courseId) {
    courseRepo.deleteById(courseId);
    return this.findAllCourses();
  }

  @PutMapping("/api/courses/{courseId}")
  public List<Course> updateCourse(@RequestBody Course target, @PathVariable("courseId") int courseId) {
    Optional<Course> optional = courseRepo.findById(courseId);
    Course course = optional.get();
    course.setTitle(target.getTitle());
    course.setModules(target.getModules());
    course.setAuthor(target.getAuthor());

    return this.findAllCourses();
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse(@RequestBody Course course) {
    courseRepo.save(course);
    return this.findAllCourses();
  }

}
