package com.rabbitmq.producer.service.impl;

import com.rabbitmq.producer.amqp.AmqpProducer;
import com.rabbitmq.producer.dto.MessageDTO;
import com.rabbitmq.producer.model.MessageEntity;
import com.rabbitmq.producer.repository.MessageRepository;
import com.rabbitmq.producer.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageImpl implements MessageService {

    @Autowired
    private AmqpProducer<MessageDTO> amqp;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public String sendMessage(final MessageDTO message) {

        log.info("POST= saving message - Menssagem recebida - salvando mensagem.");
        final MessageEntity saveMessage = messageRepository.save(message.toEntity());

        log.info("SEND= sending message - Enviando menssagem para consumidor");
        amqp.producer(message);
        return "Done!";
    }
}
