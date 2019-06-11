package com.example.myapp.models;
import javax.persistence.*;

@Entity
public class Lesson {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String title;
  private Topic topic;

  public Lesson(String title, Topic topic) {
    this.title = title;
    this.topic = topic;
  }

  public Lesson() {
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

  public Topic getTopic() {
    return topic;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }
}
