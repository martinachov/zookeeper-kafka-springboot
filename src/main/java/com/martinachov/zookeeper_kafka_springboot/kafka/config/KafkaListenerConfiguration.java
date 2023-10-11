package com.martinachov.zookeeper_kafka_springboot.kafka.config;

import com.martinachov.zookeeper_kafka_springboot.request.ProductMessage;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class KafkaListenerConfiguration {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * ConsumerFactory:
     *
     * Is used to configure and create instances of Kafka consumers.
     * It provides a way to customize various consumer properties such as BOOTSTRAP_SERVERS_CONFIG,
     * GROUP_ID_CONFIG, KEY_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER_CLASS_CONFIG, and others.
     * You should use ConsumerFactory when you want to define custom consumer properties or if you
     * need to configure deserialization for your Kafka messages.
     *
     */
    @Bean
    public ConsumerFactory<String, ProductMessage> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "consuming");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(ProductMessage.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ProductMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ProductMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        log.info("Configure concurrent consumer Kafka");
        return factory;
    }


}
