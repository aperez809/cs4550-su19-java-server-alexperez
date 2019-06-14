package com.example.myapp.repositories;

import com.example.myapp.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
  @Query(value = "select * from Topics where title=:title", nativeQuery = true)
  List<Topic> findTopicByTitle(@Param("title") String title);

  @Query(value = "select * from Topics where lesson_id=:lid", nativeQuery = true)
  List<Topic> findTopicByLessonId(@Param("lid") int lid);
}
