package com.interview.posts.rest.service

import com.interview.posts.rest.model.Category
import com.interview.posts.rest.model.Message
import com.interview.posts.rest.model.dto.MessageDto
import com.interview.posts.rest.model.parser.MessageParser
import com.interview.posts.rest.repository.MessageRepository
import spock.lang.Specification

class MessageServiceImpTest extends Specification {

    MessageServiceImp messageService
    MessageParser messageParser

    MessageRepository messageRepository = Mock()

    Message testMessage

    MessageDto testMessageDto

    void setup() {
        messageParser = new MessageParser()
        messageService = new MessageServiceImp(messageRepository, messageParser)

        testMessage = new Message(id: 1, message: "test message", author: "alex", category: new Category(id: 1))

        testMessageDto = new MessageDto(id: 1, message: "test message", author: "alex", categoryId: 1)
    }

    def "given test message when call to save message then get saved message"() {
        given:
        messageRepository.save(_ as Message) >> testMessage

        when:
        Optional<MessageDto> message = messageService.save(testMessageDto)

        then:
        message.get().id == 1
        message.get().message == "test message"
        message.get().author == "alex"
        message.get().categoryId == 1
    }
}
