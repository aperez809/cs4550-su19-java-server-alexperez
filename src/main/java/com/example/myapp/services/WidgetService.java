package com.example.myapp.services;

import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class WidgetService {
  @Autowired
  private WidgetRepository widgetRepo;

  public List<Widget> findAllWidgets() {
    return (List<Widget>) widgetRepo.findAll();
  }

  public Widget findWidgetById(int widgetId) {
    Optional<Widget> optional = widgetRepo.findById(widgetId);
    return optional.get();
  }

  public void createWidget(Widget widget) {
    widgetRepo.save(widget);
  }

  public void updateWidget(int widgetId, Widget passedWidget) {
    Optional<Widget> optional = widgetRepo.findById(widgetId);
    Widget widget = optional.get();
    widget.setWtype(passedWidget.getWtype());
    widget.setWidth(passedWidget.getWidth());
    widget.setHeight(passedWidget.getHeight());
  }

  public void deleteWidget(int widgetId) {
    widgetRepo.deleteById(widgetId);
  }
}
