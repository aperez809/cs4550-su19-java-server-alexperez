package com.example.myapp.models;
import javax.persistence.*;

@Entity
public class ParagraphWidget extends Widget {
  private String text;

  public ParagraphWidget(String wtype, Integer width, Integer height, String text) {
    super(wtype, width, height);
    this.text = text;
  }

  public ParagraphWidget() {
    super();
  }
}
