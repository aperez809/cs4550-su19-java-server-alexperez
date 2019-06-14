package com.example.myapp.repositories;

import com.example.myapp.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  @Query(value = "select * from Widgets where topic_id=:tid", nativeQuery = true)
  List<Widget> findWidgetByTopicId(@Param("tid") int tid);
}
