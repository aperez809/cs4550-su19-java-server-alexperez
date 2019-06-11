package com.example.myapp.models;

public class MultipleChoice extends Question {
  private String choices;
  private int correct;

  public MultipleChoice(String question, int points, String choices, int correct) {
    super(question, points);
    this.choices = choices;
    this.correct = correct;
  }
}
