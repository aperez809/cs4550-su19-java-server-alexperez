package com.example.myapp.controllers;

import com.example.myapp.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
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
    return userAL;
  }

  @GetMapping("/api/users/find/{userId}")
  public User findUserById(@PathVariable int userId) {
    for (User u: userAL) {
      if (u.getId() == userId) {
        return u;
      }
    }
    return null;
  }

  @DeleteMapping("/api/users/delete/{userId}")
  public List<User> deleteUser(@PathVariable("userId") int userId) {
    User toDelete = null;

    for (User u: userAL) {
      if (u.getId() == userId) {
        toDelete = u;
      }
    }

    if (toDelete != null) {
      userAL.remove(toDelete);
    }
    return userAL;
  }

  @PutMapping("/api/users/update/{userId}")
  public User updateUser(@RequestBody User target, @PathVariable("userId") int userId) {
    User toUpdate = null;

    for (User u: userAL) {
      if (u.getId() == userId) {
        toUpdate = u;
      }
    }

    if (toUpdate != null) {
      toUpdate.setUsername(target.getUsername());
      toUpdate.setPassword(target.getPassword());
      toUpdate.setFirstName(target.getFirstName());
      toUpdate.setLastName(target.getLastName());
    }

    return toUpdate;
  }

  @PostMapping("/api/users/create")
  public User createUser(@RequestBody User u) {
    u.setId(userAL.size() + 1);
    userAL.add(u);
    return u;
  }
}
