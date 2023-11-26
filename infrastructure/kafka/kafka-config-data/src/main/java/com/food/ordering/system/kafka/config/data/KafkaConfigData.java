package com.food.ordering.system.kafka.config.data;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration// sınıfı bir konfigürasyon sınıfı olarak işaretler  ve spring core injection yapısına dahil eder.
@ConfigurationProperties(prefix = "kafka-config")// application.properties dosyasındaki kafka-config başlıklı alanları bu sınıfın alanlarına map eder.
public class KafkaConfigData {
    private String bootstrapServers;
    private String schemaRegistryUrlKey;
    private String schemaRegistryUrl;
    private Integer numOfPartitions;
    private Short replicationFactor;
}
