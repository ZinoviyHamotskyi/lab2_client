package com.example.demo.ServerMethods;

import com.example.demo.model.Session;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionRequest {
    private final String url = "http://localhost:8081/clients/{id}/sessions";
    private final RestTemplate restTemplate;

    public SessionRequest() {
        restTemplate = new RestTemplate();
    }


    public void makeAppointment() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("serviceName", "massage")
                .queryParam("specialistName", "Pasha")
                .queryParam("date", "2021-02-13");


        HttpEntity<Session> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Session> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.POST, httpEntity, Session.class, "05dd1467-0814-4151-9b17-955ae0c501ee");
        System.out.println(responseEntity.getBody());
    }

    public String getSessions() {
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,null, String.class,
                "05dd1467-0814-4151-9b17-955ae0c501ee") ;
        return response.getBody();
    }

    public Session getSession(UUID id){
        String baseUrl = url + "/" + id.toString();
        return restTemplate.getForObject(baseUrl, Session.class);
    }
}
