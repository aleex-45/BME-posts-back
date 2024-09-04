package com.interview.posts.rest.service;

import com.interview.posts.rest.model.Message;
import com.interview.posts.rest.model.dto.MessageDto;
import com.interview.posts.rest.model.parser.MessageParser;
import com.interview.posts.rest.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageParser messageParser;

    public MessageServiceImp(MessageRepository messageRepository, MessageParser messageParser) {
        this.messageRepository = messageRepository;
        this.messageParser = messageParser;
    }

    public Optional<MessageDto> save(MessageDto messageDto) {
        try {
            Message message = messageRepository.save(messageParser.parseFromDTO(messageDto));

            return Optional.of(messageParser.parseToDTO(message));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

