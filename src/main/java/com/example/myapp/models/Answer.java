package com.example.myapp.models;

public class Answer {
  private Student student;
  private Question question;
  private boolean trueFalseAnswer;
  private int multipleChoiceAnswer;

  public Answer(Student student, Question question, boolean trueFalseAnswer, int multipleChoiceAnswer) {
    this.student = student;
    this.question = question;
    this.trueFalseAnswer = trueFalseAnswer;
    this.multipleChoiceAnswer = multipleChoiceAnswer;
  }
}
