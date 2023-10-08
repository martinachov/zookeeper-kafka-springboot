package com.martinachon.zookeeperkafkaspringboot.service;

import com.martinachon.zookeeperkafkaspringboot.kafka.producer.ProductProducer;
import com.martinachon.zookeeperkafkaspringboot.request.ProductMessage;
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
