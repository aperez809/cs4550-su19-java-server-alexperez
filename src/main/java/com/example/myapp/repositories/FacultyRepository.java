package com.example.myapp.repositories;

import com.example.myapp.models.Faculty;
import com.example.myapp.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyRepository extends CrudRepository<Faculty, Integer>{
  @Query(value = "select * from user where username=:username", nativeQuery = true)
  List<Faculty> findFacultyByUsername(@Param("username") String username);

  @Query(value = "select faculty from Faculty faculty where faculty.username=:username and faculty.password=:password")
  List<Faculty> findFacultyByCredentials(@Param("username") String username,
                                          @Param("password") String password);
}
