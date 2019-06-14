package com.example.myapp.services;

import com.example.myapp.models.Lesson;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
  @Autowired
  private LessonRepository lessonRepo;

  public List<Lesson> findAllLessons() {
    return (List<Lesson>) lessonRepo.findAll();
  }

  public List<Lesson> findLessonByTitle(String title) {
    return lessonRepo.findLessonByTitle(title);
  }

  public Lesson findLessonById(int lessonId) {
    Optional<Lesson> optional = lessonRepo.findById(lessonId);
    return optional.get();
  }

  public void deleteLesson(int lessonId) {
    lessonRepo.deleteById(lessonId);
  }

  public void updateLesson(Lesson target, int lessonId) {
    Optional<Lesson> optional = lessonRepo.findById(lessonId);
    Lesson lesson = optional.get();
    lesson.setTopics(target.getTopics());
    lesson.setModule(target.getModule());
    lesson.setTitle(target.getTitle());

    lessonRepo.save(lesson);
  }

  public void createLesson(Lesson lesson) {
    lessonRepo.save(lesson);
  }

  public List<Lesson> findLessonByModuleId(int moduleId) {
    return lessonRepo.findLessonByModuleId(moduleId);
  }
}
