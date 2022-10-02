package com.kenzie.appserver.service;

import com.kenzie.appserver.FlightNotFoundException;
import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.repositories.model.FlightRecord;
import com.kenzie.appserver.service.model.FlightInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.fromString;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightInfo getFlight(String flightId) {
        if (StringUtils.isEmpty(flightId) || isInvalidUuid(flightId)) {
            throw new FlightNotFoundException("Flight doesn't exist in our database!");
        }


            FlightInfo flightInfo = flightRepository
                    .findById(flightId)
                    .map(flight -> new FlightInfo(flight.getFlightId(),
                            flight.getName(),
                            flight.getEmail(),
                            flight.getOriginZipcode(),
                            flight.getDestinationZipcode(),
                            flight.getNumOfPassengers(),
                            flight.getPaymentMethod()))
                    .orElse(null);
            return flightInfo;
//        } catch (RuntimeException e) {
//            throw new FlightNotFoundException("Flight was unable to be found!");
//        }
    }

    public List<FlightInfo> getAllFlights() {
        List<FlightInfo> flightInfoList = new ArrayList<>();

        Iterable<FlightRecord> flightIterator = flightRepository.findAll();
        for (FlightRecord record : flightIterator) {
            flightInfoList.add(new FlightInfo(record.getFlightId(),
                    record.getName(),
                    record.getEmail(),
                    record.getOriginZipcode(),
                    record.getDestinationZipcode(),
                    record.getNumOfPassengers(),
                    record.getPaymentMethod()));
        }

        return flightInfoList;
    }

    public FlightInfo createFlight(FlightInfo flightInfo) {
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightInfo.getFlightId());
        flightRecord.setName(flightInfo.getName());
        flightRecord.setEmail(flightInfo.getEmail());
        flightRecord.setOriginZipcode(flightInfo.getOriginZipcode());
        flightRecord.setDestinationZipcode(flightInfo.getDestinationZipcode());
        flightRecord.setNumOfPassengers(flightInfo.getNumOfPassengers());
        flightRecord.setPaymentMethod(flightInfo.getPaymentMethod());
        flightRepository.save(flightRecord);

        return flightInfo;
    }

    public void deleteFlight(String flightId) {
        if (StringUtils.isEmpty(flightId) || isInvalidUuid(flightId)) {
            throw new FlightNotFoundException("Flight doesn't exist in our database!");
        }

        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightId);
        flightRepository.delete(flightRecord);
    }

    private boolean isInvalidUuid(String uuid) {
        try {
            fromString(uuid);
        } catch (IllegalArgumentException exception) {
            return true;
        }
        return false;
    }
}
