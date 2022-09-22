package com.kenzie.appserver.service;

import com.kenzie.appserver.FlightNotFoundException;
import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.repositories.model.FlightRecord;
import com.kenzie.appserver.service.model.FlightInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightInfo getFlight(String flightId) {
        FlightInfo flightInfo = flightRepository
                .findById(flightId)
                .map(flight -> new FlightInfo(flight.getFlightId(),
                        flight.getOriginZipcode(),
                        flight.getDestinationZipcode(),
                        flight.getPaymentMethod()))
                .orElse(null);

        return flightInfo;
    }

    public List<FlightInfo> getAllFlights() {
        List<FlightInfo> flightInfoList = new ArrayList<>();

        Iterable<FlightRecord> flightIterator = flightRepository.findAll();
        for(FlightRecord record : flightIterator){
            flightInfoList.add(new FlightInfo(record.getFlightId(),
                    record.getOriginZipcode(),
                    record.getDestinationZipcode(),
                    record.getPaymentMethod()));
        }

        return flightInfoList;
    }

    public void createFlight(FlightInfo flightInfo) {
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightInfo.getFlightId());
        flightRecord.setOriginZipcode(flightInfo.getOriginZip());
        flightRecord.setDestinationZipcode(flightInfo.getDestinationZip());
        flightRecord.setPaymentMethod(flightInfo.getPaymentMethod());
    }

    public void deleteFlight(String flightId){
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightId);
        flightRepository.delete(flightRecord);
    }
}
