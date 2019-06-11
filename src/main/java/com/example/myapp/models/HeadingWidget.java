package com.example.myapp.models;

public class HeadingWidget extends Widget{
  private int size;

  public HeadingWidget(String wtype, Integer width, Integer height, int size) {
    super(wtype, width, height);
    this.size = size;
  }
}
