package com.example.myapp.models;

import java.util.List;

public class Section {
  private String title;
  private int seats;
  private List<Enrollment> enrollment;

  public Section(String title, int seats, List<Enrollment> enrollment) {
    this.title = title;
    this.seats = seats;
    this.enrollment = enrollment;
  }
}
