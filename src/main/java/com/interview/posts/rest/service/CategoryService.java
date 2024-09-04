package com.interview.posts.rest.service;

import com.interview.posts.rest.model.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<CategoryDto>> getAll();
    Optional<CategoryDto> get(Long id);
    Optional<CategoryDto> save(CategoryDto categoryDto);
}
