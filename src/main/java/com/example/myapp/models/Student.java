package com.example.myapp.models;

public class Student extends User {
  private int gradYear;
  private Long scholarship;

  public Student(int id, String username, String password, String firstName, String lastName, int gradYear, Long scholarship) {
    super(id, username, password, firstName, lastName);
    this.gradYear = gradYear;
    this.scholarship = scholarship;
  }
}
