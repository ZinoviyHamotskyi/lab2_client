package com.example.demo.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@EnableAutoConfiguration
public final class Client {

    private  UUID id;
    private String name;
    private Date birthDate;

    public Client(String name, String birthDate) throws ParseException {
        id = UUID.randomUUID();
        this.name = name;
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Client() {}

}



