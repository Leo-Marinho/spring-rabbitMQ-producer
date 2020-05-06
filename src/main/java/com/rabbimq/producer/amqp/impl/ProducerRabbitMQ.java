package com.rabbimq.producer.amqp.impl;

import com.rabbimq.producer.amqp.AmqpProducer;
import com.rabbimq.producer.dto.MessageDTO;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.exchenge.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.dead-letter.producer}")
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
