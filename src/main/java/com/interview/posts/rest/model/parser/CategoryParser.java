package com.interview.posts.rest.model.parser;

import com.interview.posts.rest.model.Category;
import com.interview.posts.rest.model.Message;
import com.interview.posts.rest.model.dto.CategoryDto;
import com.interview.posts.rest.model.dto.MessageDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CategoryParser {

    public Category parseFromDTO(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setMessages(categoryDto.getMessages().stream()
                .map(messageDto -> new Message(messageDto.getId(), messageDto.getMessage(), messageDto.getAuthor()))
                .collect(Collectors.toList()));
        return category;
    }

    public CategoryDto parseToDTO(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setMessages(category.getMessages().stream()
                .map(message -> new MessageDto(message.getId(), message.getMessage(), message.getAuthor()))
                .collect(Collectors.toList()));
        return categoryDto;
    }

}
