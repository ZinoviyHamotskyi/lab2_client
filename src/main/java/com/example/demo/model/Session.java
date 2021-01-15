package com.example.demo.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@EnableAutoConfiguration
public final class Session {

    private UUID id;
    private UUID service;
    private UUID client;
    private UUID specialist;
    private Date date;
    private boolean finished;


    public Session(UUID service, UUID client,
                   UUID specialist, String date) {

        this.id = UUID.randomUUID();
        this.service = service;
        this.client = client;
        this.specialist = specialist;
        this.finished = false;
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public UUID getService() {
        return service;
    }

    public UUID getClient() {
        return client;
    }

    public UUID getSpecialist() {
        return specialist;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", service=" + service +
                ", client=" + client +
                ", specialist=" + specialist +
                ", date=" + date +
                ", finished=" + finished +
                '}';
    }

    public Session() {

    }
}
