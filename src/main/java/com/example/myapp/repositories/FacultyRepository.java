package com.example.myapp.repositories;

import com.example.myapp.models.Faculty;
import com.example.myapp.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyRepository extends CrudRepository<Faculty, Integer>{
  @Query(value = "select * from Users where username=:username", nativeQuery = true)
  List<Faculty> findFacultyByUsername(@Param("username") String username);

  @Query(value = "select * from Faculty where faculty.username=:username and faculty.password=:password",
  nativeQuery = true)
  List<Faculty> findFacultyByCredentials(@Param("username") String username,
                                          @Param("password") String password);
}
