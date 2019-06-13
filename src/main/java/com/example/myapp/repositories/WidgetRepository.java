package com.example.myapp.repositories;

import com.example.myapp.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

  @Query("select Widgets.wtype, Widgets.height, Widgets.width" +
          " from Widgets, Topics where Topics.id=:tid")
  List<Widget> findWidgetByTopicId(@Param("tid") int tid);
}
