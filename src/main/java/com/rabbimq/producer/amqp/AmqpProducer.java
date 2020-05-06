package com.rabbimq.producer.amqp;

public interface AmqpProducer<T> {

    void producer(final T t);
}
