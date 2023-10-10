package com.martinachov.zookeeper_kafka_springboot.request;

import lombok.Data;

@Data
public class Product {

    private String id;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"name\":\"" + name + '\"' +
                ", \"price\":\"" + price + '\"' +
                "}";
    }

}
