package com.example.myapp.models;

public class Widget {

  private String name;
  private Long id;
  private String wtype; //make ENUM
  private int order;
  private String text;
  private String url;
  private Integer size = null;
  private Integer width = null;
  private Integer height = null;
  private String cssClass;
  private String style;
  private String value;
  private String dataType; //make ENUM


  public Widget(String name, Long id, String type, int order, String text, String url, Integer size, Integer width, Integer height, String cssClass, String style, String value, String dataType) {
    this.name = name;
    this.id = id;
    this.wtype = type;
    this.order = order;
    this.text = text;
    this.url = url;
    this.size = size;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.dataType = dataType;
  }

  public Widget(Long id, String name, String type) {
    this.id = id;
    this.name = name;
    this.wtype = type;
  }

  public Widget(String wtype, Integer width, Integer height) {
    this.wtype = wtype;
    this.width = width;
    this.height = height;
  }

  public Widget() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }



  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getWtype() {
    return wtype;
  }

  public void setWtype(String wtype) {
    this.wtype = wtype;
  }

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }
}
