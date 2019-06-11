package com.example.myapp.models;
import javax.persistence.*;

@Entity
public class Faculty extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String office;
  private boolean tenured;

  public Faculty(String username, String password, String firstName, String lastName, String office, boolean tenured) {
    super(username, password, firstName, lastName);
    this.office = office;
    this.tenured = tenured;
  }

  public Faculty() {
    super();
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public boolean isTenured() {
    return tenured;
  }

  public void setTenured(boolean tenured) {
    this.tenured = tenured;
  }
}
