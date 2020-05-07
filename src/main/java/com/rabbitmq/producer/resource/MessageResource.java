package com.rabbitmq.producer.resource;

import com.rabbitmq.producer.dto.MessageDTO;
import com.rabbitmq.producer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/message")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private String send(@RequestBody @Valid final MessageDTO message){

        return messageService.sendMessage(message);
    }

}

