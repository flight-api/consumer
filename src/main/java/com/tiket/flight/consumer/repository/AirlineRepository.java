package com.tiket.flight.consumer.repository;

import com.tiket.flight.consumer.models.Airline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends MongoRepository<Airline,String>{
    public Airline findByCode(String firstName);
    public List<Airline> findByName(String name);

}
