package com.rabbitmq.producer.dto;

import com.rabbitmq.producer.model.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private String text;

    public MessageEntity toEntity(){
        return new MessageEntity(text);
    }

}
