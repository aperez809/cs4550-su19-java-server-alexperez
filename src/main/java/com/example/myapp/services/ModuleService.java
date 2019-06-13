package com.example.myapp.services;

import com.example.myapp.models.Module;
import com.example.myapp.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ModuleService {
  @Autowired
  private ModuleRepository moduleRepo;

  public List<Module> findAllModules() {
    return (List<Module>) moduleRepo.findAll();
  }

  public List<Module> findModuleByTitle(String title) {
    return moduleRepo.findModuleByTitle(title);
  }

  public Module findModuleById(int moduleId) {
    Optional<Module> optional = moduleRepo.findById(moduleId);
    return optional.get();
  }

  public void deleteModule(int moduleId) {
    moduleRepo.deleteById(moduleId);
  }

  public void updateModule(Module target, int moduleId) {
    Optional<Module> optional = moduleRepo.findById(moduleId);
    Module module = optional.get();
    module.setLessons(target.getLessons());
    module.setCourse(target.getCourse());
    module.setTitle(target.getTitle());
  }

  public void createModule(Module module) {
    moduleRepo.save(module);
  }

}
