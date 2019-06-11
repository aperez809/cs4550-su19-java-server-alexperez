package com.example.myapp.models;

public class Section {
  private String title;
  private int seats;
  private Enrollment[] enrollment;

  public Section(String title, int seats, Enrollment[] enrollment) {
    this.title = title;
    this.seats = seats;
    this.enrollment = enrollment;
  }
}
