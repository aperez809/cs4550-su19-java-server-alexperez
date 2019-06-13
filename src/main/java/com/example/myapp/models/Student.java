package com.example.myapp.models;

import javax.persistence.Entity;

@Entity
public class Student extends User {
  private Float gpa;
  private int gradYear;
  private Long scholarship;

  public Float getGpa() {
    return gpa;
  }

  public void setGpa(Float gpa) {
    this.gpa = gpa;
  }

  public int getGradYear() {
    return gradYear;
  }

  public void setGradYear(int gradYear) {
    this.gradYear = gradYear;
  }

  public Long getScholarship() {
    return scholarship;
  }

  public void setScholarship(Long scholarship) {
    this.scholarship = scholarship;
  }
}
