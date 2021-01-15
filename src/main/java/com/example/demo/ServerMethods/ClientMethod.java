package com.example.demo.ServerMethods;

import com.example.demo.model.Client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

public interface ClientMethod {

    static void createClient() {
        final String address = "http://localhost:8081/clients/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Pavel").
                queryParam("birthDate", "1987-02-11");

        System.out.println("Create new clients");

        HttpEntity<Client> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, Client.class);

        System.out.println(response.getBody());
    }

    static void getClients() {
        final String address = "http://localhost:8081/clients/{name}";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);

        System.out.println("get clients info");

        HttpEntity<Client> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.GET, null, Client.class, "Pavel");

        System.out.println(response.getBody());
    }

    static void deleteClient(){
        final String address = "http://localhost:8081/clients/{name}";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);

        System.out.println("delete clients info");

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.DELETE, null, String.class, "Pavel");

        System.out.println(response.getBody());
    }
}
