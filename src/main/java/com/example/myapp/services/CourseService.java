package com.example.myapp.services;

import com.example.myapp.models.Course;
import com.example.myapp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepo;

  public List<Course> findAllCourses() {
    return (List<Course>) courseRepo.findAll();
  }

  public List<Course> findCourseByTitle(String title) {
    return courseRepo.findCourseByTitle(title);
  }


  public Course findCourseById(int courseId) {
    Optional<Course> optional = courseRepo.findById(courseId);
    return optional.get();
  }

  public void deleteCourse(int courseId) {
    courseRepo.deleteById(courseId);
  }

  public void updateCourse(Course target, int courseId) {
    Optional<Course> optional = courseRepo.findById(courseId);
    Course course = optional.get();
    course.setTitle(target.getTitle());
    course.setModules(target.getModules());
    course.setAuthor(target.getAuthor());

    courseRepo.save(course);
  }

  public void createCourse(Course course) {
    courseRepo.save(course);
  }
}
