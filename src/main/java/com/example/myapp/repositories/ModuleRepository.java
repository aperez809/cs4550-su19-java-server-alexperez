package com.example.myapp.repositories;

import com.example.myapp.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
  @Query(value = "select * from Modules where Modules.title=:title", nativeQuery = true)
  List<Module> findModuleByTitle(@Param("title") String title);
}
