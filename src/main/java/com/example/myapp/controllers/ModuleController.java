package com.example.myapp.controllers;

import com.example.myapp.models.Module;
import com.example.myapp.repositories.ModuleRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModuleController {

  private ModuleRepository moduleRepo;

  @GetMapping("/api/modules")
  public List<Module> findAllModules() {
    return (List<Module>) moduleRepo.findAll();
  }

  @GetMapping("/api/modules/title/{title}")
  public List<Module> findModuleByTitle(@PathVariable("title") String title) {
    return moduleRepo.findModuleByTitle(title);
  }

  @GetMapping("/api/modules/{moduleId}")
  public Module findModuleById(@PathVariable("moduleId") int moduleId) {
    Optional<Module> optional = moduleRepo.findById(moduleId);
    return optional.get();
  }

  @DeleteMapping("/api/modules/{moduleId}")
  public List<Module> deleteModule(@PathVariable("moduleId") int moduleId) {
    moduleRepo.deleteById(moduleId);
    return this.findAllModules();
  }

  @PutMapping("/api/modules/{moduleId}")
  public List<Module> updateModule(@RequestBody Module target, @PathVariable("moduleId") int moduleId) {
    Optional<Module> optional = moduleRepo.findById(moduleId);
    Module module = optional.get();
    module.setLessons(target.getLessons());
    module.setCourse(target.getCourse());
    module.setTitle(target.getTitle());

    return this.findAllModules();
  }

  @PostMapping("/api/modules")
  public List<Module> createModule(@RequestBody Module module) {
    moduleRepo.save(module);
    return this.findAllModules();
  }

}
