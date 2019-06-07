package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {
  private WidgetService service;
  private WidgetController() {
    this.service = new WidgetService();
  }

  @PostMapping("/api/widgets/")
  public List<Widget> createWidget(@RequestBody Widget widget) {
    return this.service.createWidget(widget);
  }

  @GetMapping("/api/widgets/")
  public List<Widget> findAllWidgets() {
    return this.service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") Long widgetId) {
    return this.service.findWidgetById(widgetId);
  }

  @PutMapping("/api/widgets/{widgetId}")
  public List<Widget> updateWidget(@PathVariable("widgetId") Long widgetId, @RequestBody Widget passedWidget) {
    return this.service.updateWidget(widgetId, passedWidget);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public List<Widget> deleteWidget(@PathVariable("widgetId") Long widgetId) {
    return this.service.deleteWidget(widgetId);
  }
}
