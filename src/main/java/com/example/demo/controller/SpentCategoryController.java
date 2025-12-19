package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SpendCategoryController {

    private final SpendCategoryService service;

    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public SpendCategory createCategory(@RequestBody SpendCategory category) {
        return service.createCategory(category);
    }

    @GetMapping("/active")
    public List<SpendCategory> getActiveCategories() {
        return service.getActiveCategories();
    }
}
