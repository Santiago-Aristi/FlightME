package com.kenzie.appserver.service;

import com.kenzie.appserver.FlightNotFoundException;
import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.service.model.FlightInfo;

import java.util.List;

public class FlightService {
    // Hi
    //Hi from Dave
    //Hi from Jason
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightInfo getFlight(String flightId) {
        if (flightId.length() > 0) {
            return flightRepository.getFlightById(flightId);
        } else {
            throw new FlightNotFoundException(flightId);
        }
    }

    public List<FlightInfo> getAllFlights(String userId) {
        return flightRepository.getFlights(userId);
    }

    public void createFlight(FlightInfo flightInfo) {
        flightRepository.createFlight(flightInfo);
    }

    public FlightInfo deleteFlight(String flightId){
        return flightRepository.deleteFlight(flightId);
    }

}
