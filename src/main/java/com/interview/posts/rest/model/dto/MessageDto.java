package com.interview.posts.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;
    private String message;
    private String author;
    private Long categoryId;

    public MessageDto(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }
}
