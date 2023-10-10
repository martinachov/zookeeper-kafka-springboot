package com.martinachov.zookeeper_kafka_springboot.kafka.producer;

import com.martinachov.zookeeper_kafka_springboot.request.ProductMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProductProducer {

    final String productTopic = "product";

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public void send(ProductMessage message) {
        log.info("Message sent successfully with offset = {}");
        kafkaTemplate.send(productTopic, message);
    }
}
