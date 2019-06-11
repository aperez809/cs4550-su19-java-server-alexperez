package com.example.myapp.models;

import javax.persistence.*;

@Entity
public class ListWidget extends Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String[] items;
  private boolean ordered;

  public ListWidget(String wtype, Integer width, Integer height, String[] items, boolean ordered) {
    super(wtype, width, height);
    this.items = items;
    this.ordered = ordered;
  }

  public ListWidget() {
    super();
  }
}
