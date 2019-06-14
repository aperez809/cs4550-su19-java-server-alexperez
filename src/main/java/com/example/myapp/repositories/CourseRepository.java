package com.example.myapp.repositories;

import com.example.myapp.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
  @Query(value = "select * from Courses where Courses.title=:title", nativeQuery = true)
  List<Course> findCourseByTitle(@Param("title") String title);
}
