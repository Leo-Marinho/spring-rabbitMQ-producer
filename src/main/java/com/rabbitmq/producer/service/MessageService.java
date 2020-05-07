package com.rabbitmq.producer.service;

import com.rabbitmq.producer.dto.MessageDTO;

public interface MessageService {

    String sendMessage(final MessageDTO message);
}
