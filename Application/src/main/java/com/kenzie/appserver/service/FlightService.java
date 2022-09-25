package com.kenzie.appserver.service;

import com.kenzie.appserver.FlightNotFoundException;
import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.repositories.model.FlightRecord;
import com.kenzie.appserver.service.model.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightInfo getFlight(String flightId) {
        FlightInfo flightInfo = flightRepository
                .findById(flightId)
                .map(flight -> new FlightInfo(flight.getName(),
                        flight.getEmail(),
                        flight.getFlightId(),
                        flight.getOriginZipcode(),
                        flight.getDestinationZipcode(),
                        flight.getNumOfPassengers(),
                        flight.getPaymentMethod()))
                .orElse(null);

        return flightInfo;
    }

    public List<FlightInfo> getAllFlights() {
        List<FlightInfo> flightInfoList = new ArrayList<>();

        Iterable<FlightRecord> flightIterator = flightRepository.findAll();
        for(FlightRecord record : flightIterator){
            flightInfoList.add(new FlightInfo(record.getName(),
                    record.getEmail(),
                    record.getFlightId(),
                    record.getOriginZipcode(),
                    record.getDestinationZipcode(),
                    record.getNumOfPassengers(),
                    record.getPaymentMethod()));
        }

        return flightInfoList;
    }

    public FlightInfo createFlight(FlightInfo flightInfo) {
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setName(flightInfo.getName());
        flightRecord.setEmail(flightInfo.getEmail());
        flightRecord.setFlightId(flightInfo.getFlightId());
        flightRecord.setOriginZipcode(flightInfo.getOriginZipcode());
        flightRecord.setDestinationZipcode(flightInfo.getDestinationZipcode());
        flightRecord.setNumOfPassengers(flightInfo.getNumOfPassengers());
        flightRecord.setPaymentMethod(flightInfo.getPaymentMethod());
        flightRepository.save(flightRecord);

        return flightInfo;
    }

    public void deleteFlight(String flightId){
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightId);
        flightRepository.delete(flightRecord);
    }
}
