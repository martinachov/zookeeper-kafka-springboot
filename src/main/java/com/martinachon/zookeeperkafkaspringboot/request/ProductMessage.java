package com.martinachon.zookeeperkafkaspringboot.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductMessage extends Product implements Serializable {

    String action;

    public ProductMessage() {

    }

    public ProductMessage(Product p, String action) {
        this.setId(p.getId());
        this.setName(p.getName());
        this.setPrice(p.getPrice());
        this.action = action;
    }
}
