package com.interview.posts.rest.service;

import com.interview.posts.rest.model.Category;
import com.interview.posts.rest.model.dto.CategoryDto;
import com.interview.posts.rest.model.parser.CategoryParser;
import com.interview.posts.rest.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryParser categoryParser;

    public CategoryServiceImp(CategoryRepository categoryRepository, CategoryParser categoryParser) {
        this.categoryRepository = categoryRepository;
        this.categoryParser = categoryParser;
    }

    public Optional<List<CategoryDto>> getAll() {
        try {
            List<Category> categories = categoryRepository.findAll();

            return Optional.of(categories.stream().map(categoryParser::parseToDTO).collect(Collectors.toList()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<CategoryDto> get(Long id) {
        try {
            Optional<Category> category = categoryRepository.findById(id);

            return Optional.of(categoryParser.parseToDTO(category.orElseThrow()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<CategoryDto> save(CategoryDto categoryDto) {
        try {
            Category category = categoryRepository.save(categoryParser.parseFromDTO(categoryDto));

            return Optional.of(categoryParser.parseToDTO(category));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

