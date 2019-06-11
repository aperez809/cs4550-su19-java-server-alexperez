package com.example.myapp.models;

public class Faculty extends User {
  private String office;
  private boolean tenured;

  public Faculty(int id, String username, String password, String firstName, String lastName, String office, boolean tenured) {
    super(id, username, password, firstName, lastName);
    this.office = office;
    this.tenured = tenured;
  }
}
