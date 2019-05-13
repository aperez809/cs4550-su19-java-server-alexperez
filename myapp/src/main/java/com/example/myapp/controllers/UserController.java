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
                  "555-555-5555",
                  "The Builder",
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

  @GetMapping("/users")
  public User[] findAllUsers() {
    return users;
  }

  @DeleteMapping("/users/delete/{userId}")
  public List<User> deleteUser(@PathVariable("userId") int userId) {
    User toDelete = null;

    for (User u: userAL) {
      if (u.getId() == userId) {
        System.out.println("USER ID FOUND");
        toDelete = u;
      }
    }

    if (toDelete != null) {
      userAL.remove(toDelete);
    }
    System.out.println(userAL);
    return userAL;
  }

  @PutMapping("/users/edit/{userId}")
  public void editUser(@PathVariable("userId") int userId) {
    User toEdit = null;

    for (User u: userAL) {
      if (u.getId() == userId) {
        System.out.println("USER ID FOUND");
        toEdit = u;
      }
    }

    if (toEdit != null) {

    }
  }
}
