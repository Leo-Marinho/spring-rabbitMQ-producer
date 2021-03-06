package com.rabbitmq.producer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.exchenge.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.dead-letter.producer}")
    private String deadLetter;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable(queue)
                           .deadLetterExchange(exchange)
                           .deadLetterRoutingKey(deadLetter)
                           .build();
    }

    @Bean
    public Queue deadLetter() {
        return QueueBuilder.durable(deadLetter)
                           .deadLetterExchange(exchange)
                           .deadLetterRoutingKey(queue)
                           .build();
    }

    @Bean
    public Binding bindingQueue() {
        return BindingBuilder.bind(queue())
                             .to(exchange())
                             .with(queue);
    }

    @Bean
    public Binding bingingDeadLetter(){
        return BindingBuilder.bind(deadLetter())
                             .to(exchange())
                             .with(deadLetter);
    }
}

