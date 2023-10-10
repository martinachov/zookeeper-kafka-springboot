package com.martinachov.zookeeper_kafka_springboot.controller;

import com.martinachov.zookeeper_kafka_springboot.request.Product;
import com.martinachov.zookeeper_kafka_springboot.request.ProductMessage;
import com.martinachov.zookeeper_kafka_springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        log.info("[ProductController]: add new product = " + product.toString());
        this.productService.sendMessage(new ProductMessage(product, "add"));
        return ResponseEntity.ok(product);
    }
}
