package com.interview.posts.rest.model.parser;

import com.interview.posts.rest.model.Category;
import com.interview.posts.rest.model.Message;
import com.interview.posts.rest.model.dto.MessageDto;
import org.springframework.stereotype.Service;

@Service
public class MessageParser {

    public Message parseFromDTO(MessageDto messageDto) {
        Message message = new Message();
        message.setId(messageDto.getId());
        message.setMessage(messageDto.getMessage());
        message.setAuthor(messageDto.getAuthor());

        Category messageCategory = new Category();
        messageCategory.setId(messageDto.getCategoryId());
        message.setCategory(messageCategory);

        return message;
    }

    public MessageDto parseToDTO(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setId(message.getId());
        messageDto.setMessage(message.getMessage());
        messageDto.setAuthor(message.getAuthor());
        messageDto.setCategoryId(message.getId());

        return messageDto;
    }

}
