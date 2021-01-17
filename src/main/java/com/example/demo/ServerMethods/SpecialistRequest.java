package com.example.demo.ServerMethods;

import com.example.demo.model.Specialist;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpecialistRequest {
    private final String url = "http://localhost:8081/specialists";
    private final RestTemplate restTemplate;

    public SpecialistRequest() {
        restTemplate = new RestTemplate();
    }


    public void createSpecialist() {
        Map<String, Object> specialist = new HashMap<>();
        specialist.put("name", "Pasha");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(specialist, headers);
        restTemplate.postForObject(url, entity, String.class);
    }

    public Specialist[] getSpecialists() {
        return restTemplate.getForObject(url, Specialist[].class);
    }

    public Specialist getSpecialist(UUID id){
        String baseUrl = url + "/" + id.toString();
        return restTemplate.getForObject(baseUrl, Specialist.class);
    }

    public void deleteSpecialist(UUID id){
        String baseUrl = url + "/" + id.toString();
        restTemplate.delete(baseUrl);
    }
}
