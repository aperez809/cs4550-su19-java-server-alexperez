package com.example.myapp.repositories;

import com.example.myapp.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
  @Query(value = "select * from user where username=:username", nativeQuery = true)
  public List<User> findUserByUsername(@Param("username") String username);

  @Query(value = "select user from User user where user.username=:username and user.password=:password")
  public List<User> findUserByCredentials(@Param("username") String username,
                                    @Param("password") String password);



}
