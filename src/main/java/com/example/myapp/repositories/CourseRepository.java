package com.example.myapp.repositories;

import com.example.myapp.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
  @Query(value = "select * from Courses where Courses.title=:title", nativeQuery = true)
  List<Course> findCourseByTitle(String title);
}
