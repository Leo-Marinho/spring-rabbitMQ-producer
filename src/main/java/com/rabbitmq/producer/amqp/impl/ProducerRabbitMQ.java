package com.rabbitmq.producer.amqp.impl;

import com.rabbitmq.producer.amqp.AmqpProducer;
import com.rabbitmq.producer.dto.MessageDTO;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchenge.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.dead-letter.producer}")
    private String deadLetter;


    @Override
    public void producer(final MessageDTO message) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, message);
        } catch (final Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
