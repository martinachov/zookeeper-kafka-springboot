package com.martinachov.zookeeper_kafka_springboot.service;

import com.martinachov.zookeeper_kafka_springboot.kafka.producer.ProductProducer;
import com.martinachov.zookeeper_kafka_springboot.request.ProductMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductProducer productProducer;

    public void sendMessage(ProductMessage message) {
        log.info("[ProductService] send product to topic");
        productProducer.send(message);
    }
}
