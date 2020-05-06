package com.rabbimq.producer.service.impl;

import com.rabbimq.producer.amqp.AmqpProducer;
import com.rabbimq.producer.dto.MessageDTO;
import com.rabbimq.producer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImpl implements MessageService {

    @Autowired
    private AmqpProducer<MessageDTO> amqp;

    @Override
    public String sendMessage(final MessageDTO message) {

        amqp.producer(message);
        return "Done!";
    }
}
