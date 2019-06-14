package com.example.myapp.controllers;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.services.TopicService;
import com.example.myapp.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TopicController {

  @Autowired
  private WidgetService widgetService;
  @Autowired
  private TopicService topicService;

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return topicService.findAllTopics();
  }

  @GetMapping("/api/topics/title/{title}")
  public List<Topic> findTopicByTitle(@PathVariable("title") String title) {
    return topicService.findTopicByTitle(title);
  }

  @GetMapping("/api/topics/{topicId}")
  public Topic findTopicById(@PathVariable("topicId") int topicId) {
    return this.topicService.findTopicById(topicId);
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicByLessonId(@PathVariable("lessonId") int lessonId) {
    return this.topicService.findTopicByLessonId(lessonId);
  }

  @PutMapping("/api/topics/{tid}/widgets/{wid}")
  public void setWidgetBelongingToTopic(@PathVariable("tid") Integer tid,
                                         @PathVariable("wid") Integer wid) {
    Widget widget = widgetService.findWidgetById(wid);
    Topic topic = topicService.findTopicById(tid);

    widget.setTopic(topic);

    widgetService.updateWidget(widget, wid);
  }

  @DeleteMapping("/api/topics/{topicId}")
  public List<Topic> deleteTopic(@PathVariable("topicId") int topicId) {
    topicService.deleteTopic(topicId);
    return this.findAllTopics();
  }

  @PutMapping("/api/topics/{topicId}")
  public List<Topic> updateTopic(@RequestBody Topic target, @PathVariable("topicId") int topicId) {
    topicService.updateTopic(target, topicId);
    return this.findAllTopics();
  }

  @PostMapping("/api/topics")
  public List<Topic> createTopic(@RequestBody Topic topic) {
    topicService.createTopic(topic);
    return this.findAllTopics();
  }

}
