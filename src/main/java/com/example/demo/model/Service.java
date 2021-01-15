package com.example.demo.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.UUID;


@EnableAutoConfiguration
public final class Service {

    private UUID id;
    private String name;
    private double price;

    public Service(String name, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public Service() {}

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return  price;
    }
}
