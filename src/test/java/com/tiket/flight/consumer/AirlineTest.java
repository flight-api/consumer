package com.tiket.flight.consumer;

import com.tiket.flight.consumer.consumers.AirlineConsumer;
import com.tiket.flight.consumer.models.Airline;
import com.tiket.flight.consumer.repository.AirlineRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AirlineTest {
    @Mock
    AirlineRepository repository;

    @InjectMocks
    AirlineConsumer consumer;

    @Before
    public void mocking(){
        Airline airline = new Airline();
        airline.setCode("LION");
        when(repository.save(any(Airline.class))).thenReturn(airline);
    }

    @Test
    public void createAirline() throws IOException {
        consumer.airlineCreate("{\n" +
                "\"code\":\"LION\",\n" +
                "\"name\": \"LION YK-CKG\",\n" +
                "\"status\":\"INACTIVE\"\n" +
                "}");
    }

    @Test
    public void updateAirline() throws IOException {
        consumer.airlineUpdate("{\"_id\":\"1\",\n" +
                "\"code\":\"LION\",\n" +
                "\"name\": \"LION YK-CKG\",\n" +
                "\"status\":\"INACTIVE\"\n" +
                "}");
    }
}


