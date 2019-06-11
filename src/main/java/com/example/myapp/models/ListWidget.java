package com.example.myapp.models;

public class ListWidget extends Widget {
  private String[] items;
  private boolean ordered;

  public ListWidget(String wtype, Integer width, Integer height, String[] items, boolean ordered) {
    super(wtype, width, height);
    this.items = items;
    this.ordered = ordered;
  }
}
