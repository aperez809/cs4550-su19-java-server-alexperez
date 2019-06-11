package com.example.myapp.models;

public class Enrollment {
  private Student student;
  private String feedback;

  public Enrollment(Student student, String feedback) {
    this.student = student;
    this.feedback = feedback;
  }
}
