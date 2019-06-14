package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.models.Module;
import com.example.myapp.services.CourseService;
import com.example.myapp.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @Autowired
  private ModuleService modService;

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return courseService.findAllCourses();
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

  @PutMapping("/api/courses/{cid}/modules/{mid}")
  public void setModuleBelongingToCourse(@PathVariable("cid") Integer cid,
                                         @PathVariable("mid") Integer mid) {
    Course course = courseService.findCourseById(cid);
    Module module = modService.findModuleById(mid);

    module.setCourse(course);

    modService.updateModule(module, mid);
  }

  @PostMapping("/api/courses")
  public List<Course> createCourse(@RequestBody Course course) {
    courseService.createCourse(course);
    return this.findAllCourses();
  }
}
