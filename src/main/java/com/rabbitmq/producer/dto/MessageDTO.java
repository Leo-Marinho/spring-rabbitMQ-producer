package com.rabbitmq.producer.dto;

import com.rabbitmq.producer.model.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO implements Serializable {

    private String text;

    public MessageEntity toEntity(){
        return new MessageEntity(text);
    }

}
