package com.interview.posts.rest.service;

import com.interview.posts.rest.model.dto.MessageDto;

import java.util.Optional;

public interface MessageService {

    Optional<MessageDto> save(MessageDto messageDto);
}
