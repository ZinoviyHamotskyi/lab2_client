package com.example.demo.ServerMethods;

import com.example.demo.model.Client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

public class ClientRequest {

    private final String url = "http://localhost:8081/clients";
    private final RestTemplate restTemplate;

    public ClientRequest() {
        restTemplate = new RestTemplate();
    }


    public void createClient() {
        Map<String, Object> client = new HashMap<>();
        client.put("name", "Pavlo");
        client.put("birthDate", "1987-02-11");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(client, headers);
        restTemplate.postForObject(url, entity, String.class);
    }

    public Client[] getClients() {
        return restTemplate.getForObject(url, Client[].class);
    }

    public Client getClient(UUID id){
        String baseUrl = url + "/" + id.toString();
        return restTemplate.getForObject(baseUrl, Client.class);
    }

    public void deleteClient(UUID id){
        String baseUrl = url + "/" + id.toString();
        restTemplate.delete(baseUrl);
    }
}
