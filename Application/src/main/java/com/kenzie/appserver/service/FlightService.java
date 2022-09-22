package com.kenzie.appserver.service;

import com.kenzie.appserver.FlightNotFoundException;
import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.repositories.model.FlightRecord;
import com.kenzie.appserver.service.model.FlightInfo;

import java.util.List;

public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightInfo getFlight(String flightId) {
        FlightInfo flightInfo = flightRepository
                .findById(flightId)
                .map(flight -> new FlightInfo())
                .orElse(null);

        return flightInfo;
    }

//    public List<FlightInfo> getAllFlights(String userId) {
//        return flightRepository.getFlights(userId);
//    }

    public void createFlight(FlightInfo flightInfo) {
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightInfo.getFlightId());
        flightRecord.setLocation(flightInfo.getLocation());
        flightRecord.setPaymentMethod(flightInfo.getPaymentMethod());
    }

    public void deleteFlight(String flightId){
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightId);
        flightRepository.delete(flightRecord);
    }
}
