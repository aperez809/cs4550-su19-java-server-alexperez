package com.example.myapp.models;

import javax.persistence.*;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  public Course() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public Module getModule() {
    return module;
  }

  public void setModule(Module module) {
    this.module = module;
  }

  public Faculty getAuthor() {
    return author;
  }

  public void setAuthor(Faculty author) {
    this.author = author;
  }
}
