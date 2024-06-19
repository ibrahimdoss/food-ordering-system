package com.food.ordering.system.kafka.consumer.config;

import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;

public interface KafkaSingleItemConsumer<T extends SpecificRecordBase> {

    void receive(T message, String key, Integer partition, Long offset);
}
