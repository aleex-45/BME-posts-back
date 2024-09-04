package com.interview.posts.rest.controller;

import com.interview.posts.rest.model.dto.CategoryDto;
import com.interview.posts.rest.service.CategoryServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryServiceImp categoryService;

    public CategoryController(CategoryServiceImp categoryService) {
        this.categoryService = categoryService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAll() {
        Optional<List<CategoryDto>> categories = categoryService.getAll();
        if (categories.isPresent()) {
            return ResponseEntity.ok(categories.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<CategoryDto> get(@RequestParam("id") Long id) {
        Optional<CategoryDto> Category = categoryService.get(id);
        if (Category.isPresent()) {
            return ResponseEntity.ok(Category.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        Optional<CategoryDto> category = categoryService.save(categoryDto);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
