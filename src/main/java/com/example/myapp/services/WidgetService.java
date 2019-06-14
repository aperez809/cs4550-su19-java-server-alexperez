package com.example.myapp.services;

import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

  public void updateWidget(Widget passedWidget, int widgetId) {
    Optional<Widget> optional = widgetRepo.findById(widgetId);
    Widget widget = optional.get();
    widget.setType(passedWidget.getType());
    widget.setWidth(passedWidget.getWidth());
    widget.setHeight(passedWidget.getHeight());

    widgetRepo.save(widget);
  }

  public void deleteWidget(int widgetId) {
    widgetRepo.deleteById(widgetId);
  }

  public List<Widget> findAllWidgets(int tid) {
    return widgetRepo.findWidgetByTopicId(tid);
  }
}
