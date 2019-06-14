package com.example.myapp.repositories;

import com.example.myapp.models.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
  @Query(value = "select * from Lessons where title=:title", nativeQuery = true)
  List<Lesson> findLessonByTitle(@Param("title") String title);

  @Query(value = "select * from Lessons where module_id=:mid", nativeQuery = true)
  List<Lesson> findLessonByModuleId(@Param("mid") int mid);
}
