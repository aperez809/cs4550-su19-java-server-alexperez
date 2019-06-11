package com.example.myapp.models;

public class ImageWidget extends Widget {
  private String src;

  public ImageWidget(String wtype, Integer width, Integer height, String src) {
    super(wtype, width, height);
    this.src = src;
  }
}
