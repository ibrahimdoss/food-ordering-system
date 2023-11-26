package com.food.ordering.system.kafka.producer.service;

import com.food.ordering.system.kafka.producer.exception.KafkaProducerException;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PreDestroy;
import java.io.Serializable;

@Component // bu notasyon ile bu sınıfın bir Spring Bean'i olduğunu belirtiyoruz.
@Slf4j
public class KafkaProducerImpl <K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K, V>{

    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<K, V> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String topicName, K key, V message, ListenableFutureCallback<SendResult<K, V>> callback) {
        log.info("Message sending to topic: {}",message, topicName);
        try{
            ListenableFuture<SendResult<K, V>> kafkaResultFuture = kafkaTemplate.send(topicName, key, message);
            kafkaResultFuture.addCallback(callback);
        } catch (KafkaException e){
            log.error("Error on kafka producer with key: {}, message: {} and exception: {}", key, message, e.getMessage());

            throw new KafkaProducerException("Error on kafka producer with key: " + key + " and message:" + message);
        }
    }

    @PreDestroy //predestroy ile bu sınıfın destroy edilmeden önce çalıştırılacak bir metot olduğunu belirtiyoruz.
    //destroy edilmesi demek uygulamanın kapatılması demektir.
    public void close(){
        if(kafkaTemplate != null){
            log.info("CLosing kafka producer!");
            kafkaTemplate.destroy();
        }
    }
}
