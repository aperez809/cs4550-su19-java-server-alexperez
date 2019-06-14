package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.models.Topic;
import com.example.myapp.services.LessonService;
import com.example.myapp.services.ModuleService;
import com.example.myapp.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LessonController {

  @Autowired
  private TopicService topicService;
  @Autowired
  private LessonService lessonService;

  @GetMapping("/api/lessons")
  public List<Lesson> findAllLessons() {
    return lessonService.findAllLessons();
  }

  @GetMapping("/api/lessons/title/{title}")
  public List<Lesson> findLessonByTitle(@PathVariable("title") String title) {
    return lessonService.findLessonByTitle(title);
  }

  @GetMapping("/api/lessons/{lessonId}")
  public Lesson findLessonById(@PathVariable("lessonId") int lessonId) {
    return this.lessonService.findLessonById(lessonId);
  }

  @GetMapping("/api/modules/{moduleId}/lessons")
  public List<Lesson> findLessonByModuleId(@PathVariable("moduleIdId") int moduleId) {
    return this.lessonService.findLessonByModuleId(moduleId);
  }

  @PutMapping("/api/lessons/{lid}/topics/{tid}")
  public void setLessonBelongingToModule(@PathVariable("mid") Integer lid,
                                         @PathVariable("lid") Integer tid) {
    Lesson lesson = lessonService.findLessonById(lid);
    Topic topic = topicService.findTopicById(tid);

    topic.setLesson(lesson);

    topicService.updateTopic(topic, tid);
  }

  @DeleteMapping("/api/lessons/{lessonId}")
  public List<Lesson> deleteLesson(@PathVariable("moduleId") int lessonId) {
    lessonService.deleteLesson(lessonId);
    return this.findAllLessons();
  }

  @PutMapping("/api/lessons/{lessonId}")
  public List<Lesson> updateLesson(@RequestBody Lesson target, @PathVariable("moduleId") int lessonId) {
    lessonService.updateLesson(target, lessonId);
    return this.findAllLessons();
  }

  @PostMapping("/api/modules")
  public List<Lesson> createLesson(@RequestBody Lesson module) {
    lessonService.createLesson(module);
    return this.findAllLessons();
  }

}
