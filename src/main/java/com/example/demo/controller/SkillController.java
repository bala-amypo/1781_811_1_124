package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService service;

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return service.save(skill);
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Skill getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Skill update(
            @PathVariable Long id,
            @RequestBody Skill skill) {
        return service.updateSkill(id, skill);
    }
}
