package com.example.myapp.controllers;

import com.example.myapp.models.Module;
import com.example.myapp.services.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ModuleController {

  private ModuleService modService;

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
