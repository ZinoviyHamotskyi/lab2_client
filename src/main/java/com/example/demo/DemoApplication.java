package com.example.demo;

import com.example.demo.ServerMethods.ClientRequest;
import com.example.demo.ServerMethods.ServiceRequest;
import com.example.demo.ServerMethods.SessionRequest;
import com.example.demo.ServerMethods.SpecialistRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ClientRequest clientRequest = new ClientRequest();
        SpecialistRequest specialistRequest = new SpecialistRequest();
        ServiceRequest serviceRequest = new ServiceRequest();
        SessionRequest sessionRequest = new SessionRequest();

        System.out.println(clientRequest.getClients().length);
        clientRequest.deleteClient(UUID.fromString("a644fdf6-7c6a-4fa0-8c1f-6d23dcfc4dce"));
        System.out.println(clientRequest.getClients().length);

        System.out.println(specialistRequest.getSpecialists().length);
        specialistRequest.createSpecialist();
        System.out.println(specialistRequest.getSpecialists().length);


        System.out.println(serviceRequest.getServices().length);
        serviceRequest.createService();
        System.out.println(serviceRequest.getServices().length);

        System.out.println(sessionRequest.getSessions());
        sessionRequest.makeAppointment();
        System.out.println(sessionRequest.getSessions());


    }

}
