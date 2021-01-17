package com.example.demo.ServerMethods;

import com.example.demo.model.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServiceRequest {
    private final String url = "http://localhost:8081/services";
    private final RestTemplate restTemplate;

    public ServiceRequest() {
        restTemplate = new RestTemplate();
    }


    public void createService() {
        Map<String, Object> service = new HashMap<>();
        service.put("name", "massage");
        service.put("price", "250");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(service, headers);
        restTemplate.postForObject(url, entity, String.class);
    }

    public Service[] getServices() {
        return restTemplate.getForObject(url, Service[].class);
    }

    public Service getService(UUID id){
        String baseUrl = url + "/" + id.toString();
        return restTemplate.getForObject(baseUrl, Service.class);
    }

    public void deleteService(UUID id){
        String baseUrl = url + "/" + id.toString();
        restTemplate.delete(baseUrl);
    }
}
