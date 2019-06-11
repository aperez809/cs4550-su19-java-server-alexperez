package com.example.myapp.models;

public class Course {
  private String title;
  private Section section;
  private Module module;
  private Faculty author;

  public Course(String title, Section section, Module module, Faculty author) {
    this.title = title;
    this.section = section;
    this.module = module;
    this.author = author;
  }
}
