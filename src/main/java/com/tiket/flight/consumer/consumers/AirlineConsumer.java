package com.tiket.flight.consumer.consumers;

import com.google.gson.Gson;
import com.tiket.flight.consumer.models.Airline;
import com.tiket.flight.consumer.repository.AirlineRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class AirlineConsumer {

    @Autowired
    private AirlineRepository airlineRepository;

    @KafkaListener(topics = "airline-create", groupId = "airline_create")
    public void airlineCreate(String message) throws IOException {
        // url is the free music archive url.
        Gson gson = new Gson();
        Airline airline = gson.fromJson(message, Airline.class);
        UUID uuid = UUID.randomUUID();
        airline.set_id(uuid.toString());
        airlineRepository.save(airline);
        System.out.println(String.format("#### -> Create message -> %s", message));
    }

    @KafkaListener(topics = "airline-update", groupId = "airline_update")
    public void airlineUpdate(String message) throws IOException {
        Gson gson = new Gson();
        Airline airline = gson.fromJson(message, Airline.class);
        airlineRepository.save(airline);
        System.out.println(String.format("#### -> Update message -> %s", message));
    }
}
