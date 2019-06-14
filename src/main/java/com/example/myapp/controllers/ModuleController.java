package com.example.myapp.controllers;

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.services.LessonService;
import com.example.myapp.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ModuleController {

  @Autowired
  private ModuleService modService;
  @Autowired
  private LessonService lessonService;

  @GetMapping("/api/modules")
  public List<Module> findAllModules() {
    return modService.findAllModules();
  }

  @GetMapping("/api/modules/title/{title}")
  public List<Module> findModuleByTitle(@PathVariable("title") String title) {
    return modService.findModuleByTitle(title);
  }

  @GetMapping("/api/modules/{moduleId}")
  public Module findModuleById(@PathVariable("moduleId") int moduleId) {
    return this.modService.findModuleById(moduleId);
  }

  @GetMapping("/api/courses/{courseId}/modules")
  public List<Module> findModuleByCourseId(@PathVariable("courseId") int courseId) {
    return this.modService.findModuleByCourseId(courseId);
  }

  @PutMapping("/api/modules/{mid}/lesson/{lid}")
  public void setModuleBelongingToCourse(@PathVariable("mid") Integer mid,
                                         @PathVariable("lid") Integer lid) {
    Module module = modService.findModuleById(mid);
    Lesson lesson = lessonService.findLessonById(mid);

    lesson.setModule(module);

    lessonService.updateLesson(lesson, lid);
  }

  @DeleteMapping("/api/modules/{moduleId}")
  public List<Module> deleteModule(@PathVariable("moduleId") int moduleId) {
    modService.deleteModule(moduleId);
    return this.findAllModules();
  }

  @PutMapping("/api/modules/{moduleId}")
  public List<Module> updateModule(@RequestBody Module target, @PathVariable("moduleId") int moduleId) {
    modService.updateModule(target, moduleId);
    return this.findAllModules();
  }

  @PostMapping("/api/modules")
  public List<Module> createModule(@RequestBody Module module) {
    modService.createModule(module);
    return this.findAllModules();
  }

}
