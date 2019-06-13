package com.example.myapp.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty extends User {

  private String office;
  private boolean tenured;

  @OneToMany(mappedBy = "author")
  private List<Course> authoredCourses;

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

  public List<Course> getAuthoredCourses() {
    return authoredCourses;
  }

  public void setAuthoredCourses(List<Course> authoredCourses) {
    this.authoredCourses = authoredCourses;
  }
}
