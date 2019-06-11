package com.example.myapp.models;

public class TrueFalse extends Question {
  private boolean isTrue;

  public TrueFalse(String question, int points, boolean isTrue) {
    super(question, points);
    this.isTrue = isTrue;
  }
}
