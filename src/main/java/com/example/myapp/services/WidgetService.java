package com.example.myapp.services;

import com.example.myapp.models.Widget;
import java.util.ArrayList;
import java.util.List;

public class WidgetService {
  private List<Widget> widgetsAL;

  public WidgetService() {
    this.widgetsAL = new ArrayList<>();
    widgetsAL.add(new Widget("GRNIG", 654326L, "HEADING", 1, "FJIOgreWG", "FJEIOWJ", 1,1,1,"fea","gdfsg","fdsg",null));
    widgetsAL.add(new Widget("GRNIgvweG", 6326L, "PARAGRAPH", 1, "FgerwgJIOWG", "FJEIOWJ", 1,1,1,"fea","gdfsg","fdsg",null));
    widgetsAL.add(new Widget("GRNgewgeIG", 654336L, "IMAGE", 1, "gerwgeFJIOWG", "FJEIOWJ", 1,1,1,"fea","gdfsg","fdsg",null));
  }

  public List<Widget> createWidget(Widget widget) {
    this.widgetsAL.add(widget);
    return this.widgetsAL;
  }


  public List<Widget> findAllWidgets() {
    return this.widgetsAL;
  }


  public Widget findWidgetById(Long widgetId) {
    for (Widget w: this.widgetsAL) {
      if (w.getId() == widgetId) {
        return w;
      }
    }

    return null;
  }

  public List<Widget> updateWidget(Long widgetId, Widget passedWidget) {
    for (int i = 0; i < this.widgetsAL.size(); i++) {
      if (this.widgetsAL.get(i).getId() == widgetId) {
        this.widgetsAL.set(i, passedWidget);
        return this.widgetsAL;
      }
    }
    return null;
  }

  public List<Widget> deleteWidget(Long widgetId) {
    for (int i = 0; i < this.widgetsAL.size(); i++) {
      if (this.widgetsAL.get(i).getId().equals(widgetId)) {
        this.widgetsAL.remove(i);
        return this.widgetsAL;
      }
    }

    return this.widgetsAL;
  }
}
