package com.rabbimq.producer.service;

import com.rabbimq.producer.dto.MessageDTO;

public interface MessageService {

    String sendMessage(final MessageDTO message);
}
