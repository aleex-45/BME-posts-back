package com.interview.posts.rest.controller;

import com.interview.posts.rest.model.dto.MessageDto;
import com.interview.posts.rest.service.MessageService;
import com.interview.posts.rest.service.MessageServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageServiceImp messageService) {
        this.messageService = messageService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto messageDto) {
        Optional<MessageDto> message = messageService.save(messageDto);
        if (message.isPresent()) {
            return ResponseEntity.ok(message.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
