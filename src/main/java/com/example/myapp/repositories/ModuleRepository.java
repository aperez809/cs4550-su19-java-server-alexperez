package com.example.myapp.repositories;

import com.example.myapp.models.Module;
import com.example.myapp.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {
  @Query(value = "select * from Modules where title=:title", nativeQuery = true)
  List<Module> findModuleByTitle(@Param("title") String title);

  @Query(value = "select * from Modules where course_id=:cid", nativeQuery = true)
  List<Module> findModuleByCourseId(@Param("cid") int cid);


}
