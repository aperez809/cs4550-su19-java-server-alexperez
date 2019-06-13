package com.example.myapp.controllers;

import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
  @Autowired
  UserRepository userRepo;
  private int idIncrementer = 3;
  User[] users = {
          new User(1,
                  "alice",
                  "alice",
                  "Alice",
                  "Wonderland",
                  "301-767-6814",
                  "Faculty",
                  new Date(1996, 9, 5)),
          new User(2,
                  "bob",
                  "bob",
                  "Bob",
                  "The Builder",
                  "555-555-5555",

                  "Admin",
                  new Date(1994, 6, 12)),
          new User(3,
                  "charlie",
                  "charlie",
                  "Charlie",
                  "Day",
                  "111-867-5309",
                  "Student",
                  new Date(1984, 12, 8))
  };

  List<User> userAL = new ArrayList<>(Arrays.asList(users));

  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return (List<User>) userRepo.findAll();
  }

  @GetMapping("/api/users/username/{username}")
  public List<User> findUserByUsername(@PathVariable("username") String username) {
    return (List<User>) userRepo.findUserByUsername(username);
  }

  @GetMapping("/api/users/username/{username}/password/{password}")
  public List<User> findUserByCredentials(@PathVariable("username") String username,
                                          @PathVariable("password") String password) {
    return (List<User>) userRepo.findUserByCredentials(username, password);
  }

  @GetMapping("/api/users/{userId}")
  public User findUserById(@PathVariable int userId) {
    Optional<User> optional = userRepo.findById(userId);
    return optional.get();
  }

  @DeleteMapping("/api/users/{userId}")
  public List<User> deleteUser(@PathVariable("userId") int userId) {
    userRepo.deleteById(userId);
    return this.findAllUsers();
  }

  @PutMapping("/api/users/{userId}")
  public List<User> updateUser(@RequestBody User target, @PathVariable("userId") int userId) {
    Optional<User> optional = userRepo.findById(userId);
    User user = optional.get();
    user.setUsername(target.getUsername());
    user.setFirstName(target.getFirstName());
    user.setLastName(target.getLastName());
    user.setPassword(target.getPassword());

    return this.findAllUsers();
  }

  @PostMapping("/api/users")
  public List<User> createUser(@RequestBody User u) {
    userRepo.save(u);
    return this.findAllUsers();
  }
}
