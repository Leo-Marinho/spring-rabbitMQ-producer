package com.rabbimq.producer.resource;

import com.rabbimq.producer.dto.MessageDTO;
import com.rabbimq.producer.service.MessageService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private String send(final MessageDTO message){

        return messageService.sendMessage(message);
    }

}

