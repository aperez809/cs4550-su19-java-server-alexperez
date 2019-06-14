package com.example.myapp.services;

import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
  @Autowired
  UserRepository userRepo;

  @GetMapping("api/users/")
  public List<User> findAllUsers(@RequestParam(name="username", required = false) String username,
                                 @RequestParam(name="password", required = false) String password) {
    if (username != null) {
      if (password != null) {
        return userRepo.findUserByCredentials(username, password);
      }

      return userRepo.findUserByUsername(username);
    }
    return (List<User>) userRepo.findAll();
  }

  @PostMapping("api/users/")
  public User createUser(@RequestBody User user) {
    return userRepo.save(user);
  }
}
