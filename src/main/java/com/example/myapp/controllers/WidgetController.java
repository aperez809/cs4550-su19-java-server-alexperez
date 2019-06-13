package com.example.myapp.controllers;

import com.example.myapp.models.Widget;
import com.example.myapp.services.WidgetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {
  private WidgetService widgetService;
  /*private WidgetController() {
    this.service = new WidgetService();
  }
  */

  @GetMapping("/api/topic/{tid}/widgets")
  public List<Widget> findAllWidgets(@PathVariable("tid") int tid) {
    return widgetService.findAllWidgets(tid);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return widgetService.findAllWidgets();
  }


  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
    return widgetService.findWidgetById(widgetId);
  }

  @PutMapping("/api/widgets/{widgetId}")
  public List<Widget> updateWidget(@PathVariable("widgetId") int widgetId, @RequestBody Widget passedWidget) {
    widgetService.updateWidget(widgetId, passedWidget);
    return this.findAllWidgets();
  }

  @PostMapping("/api/widgets")
  public List<Widget> createWidget(@RequestBody Widget widget) {
    widgetService.createWidget(widget);
    return this.findAllWidgets();
  }


  @DeleteMapping("/api/widgets/{widgetId}")
  public List<Widget> deleteWidget(@PathVariable("widgetId") int widgetId) {
    widgetService.deleteWidget(widgetId);
    return this.findAllWidgets();
  }
}
