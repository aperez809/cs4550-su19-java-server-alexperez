package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("https://localhost:3000/*")
public class WidgetController {
  private List<Widget> widgetsAL;
  private WidgetController() {
    this.widgetsAL = new ArrayList<>();
    widgetsAL.add(new Widget());
    widgetsAL.add(new Widget());
    widgetsAL.add(new Widget());

  }

  @PostMapping("/api/widgets/")
  public List<Widget> createWidget(@RequestBody Widget widget) {
    this.widgetsAL.add(widget);
    return this.widgetsAL;
  }

  @GetMapping("/api/widgets/")
  public List<Widget> findAllWidgets() {
    return this.widgetsAL;
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
    for (Widget w: this.widgetsAL) {
      if (w.getId() == widgetId) {
        return w;
      }
    }

    return null;
  }

  @PutMapping("/api/widgets/{widgetId}")
  public List<Widget> updateWidget(@PathVariable("widgetId") int widgetId, @RequestBody Widget passedWidget) {
    for (int i = 0; i < this.widgetsAL.size(); i++) {
      if (this.widgetsAL.get(i).getId() == widgetId) {
        this.widgetsAL.set(i, passedWidget);
        return this.widgetsAL;
      }
    }
    return null;
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public List<Widget> deleteWidget(@PathVariable("widgetId") int widgetId) {
    for (int i = 0; i < this.widgetsAL.size(); i++) {
      if (this.widgetsAL.get(i).getId() == widgetId) {
        this.widgetsAL.remove(i);
        return this.widgetsAL;
      }
    }
    return null;
  }
}
