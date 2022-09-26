package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.repositories.model.FlightRecord;
//import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.FlightInfo;
//import com.kenzie.appserver.service.model.OriginZip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class FlightServiceTest {
    public static final String name = "name";
    public static final String email = "email@gmail.com";
    public static final Integer numOfPassengers = 3;
    public static final String flightId = UUID.randomUUID().toString();
    public static final String paymentMethod = "Credit Card";
    public static final String originZipcode = "12345";
    public static final String destinationZipcode = "54321";

    private FlightRepository flightRepository;

    private FlightService flightService;

    @BeforeEach
    void setup() {
        flightRepository = mock(FlightRepository.class);
        flightService = new FlightService(flightRepository);
    }

    @Test
    public void getFlight_validInput_returnsValidFLights() {
        // GIVEN
        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setName(name);
        flightRecord.setEmail(email);
        flightRecord.setFlightId(flightId);
        flightRecord.setOriginZipcode(originZipcode);
        flightRecord.setDestinationZipcode(destinationZipcode);
        flightRecord.setNumOfPassengers(numOfPassengers);
        flightRecord.setPaymentMethod(paymentMethod);

        // WHEN
        when(flightRepository.findById(flightId)).thenReturn(Optional.of(flightRecord));
        FlightInfo flightInfo = flightService.getFlight(flightId);

        // THEN
        Assertions.assertNotNull(flightInfo, "The flight is returned properly");
        Assertions.assertEquals(flightRecord.getName(), flightInfo.getName(), "Both names match");
        Assertions.assertEquals(flightRecord.getEmail(), flightInfo.getEmail(), "Both emails match");
        Assertions.assertEquals(flightRecord.getFlightId(), flightInfo.getFlightId(), "Both id match");
        Assertions.assertEquals(flightRecord.getOriginZipcode(), flightInfo.getOriginZipcode(), "Both zip codes match");
        Assertions.assertEquals(flightRecord.getDestinationZipcode(), flightInfo.getDestinationZipcode(), "Both zip codes match");
        Assertions.assertEquals(flightRecord.getNumOfPassengers(), flightInfo.getNumOfPassengers(), "Both number of passengers match");
        Assertions.assertEquals(flightRecord.getPaymentMethod(), flightInfo.getPaymentMethod(), "Both payments match");
    }

    @Test
    public void createFlight_validInput_CreatesValidFlight(){
        FlightInfo flightInfo = new FlightInfo(name, email, flightId, originZipcode, destinationZipcode, numOfPassengers, paymentMethod);
        ArgumentCaptor<FlightRecord> flightRecordCaptor = ArgumentCaptor.forClass(FlightRecord.class);

        // WHEN
        FlightInfo returnedFlight = flightService.createFlight(flightInfo);

        // THEN
        Assertions.assertNotNull(returnedFlight);
        verify(flightRepository).save(flightRecordCaptor.capture());
        FlightRecord flightRecord = flightRecordCaptor.getValue();

        Assertions.assertNotNull(flightRecord, "The flightRecord record is returned");
        Assertions.assertEquals(flightRecord.getName(), flightInfo.getName(), "The flight name matches");
        Assertions.assertEquals(flightRecord.getEmail(), flightInfo.getEmail(), "The flight email matches");
        Assertions.assertEquals(flightRecord.getFlightId(), flightInfo.getFlightId(), "The flight id matches");
        Assertions.assertEquals(flightRecord.getOriginZipcode(), flightInfo.getOriginZipcode(), "The flight origin zipcode matches");
        Assertions.assertEquals(flightRecord.getDestinationZipcode(), flightInfo.getDestinationZipcode(), "The flight destination zipcode matches");
        Assertions.assertEquals(flightRecord.getNumOfPassengers(), flightInfo.getNumOfPassengers(), "The number of passengers match");
        Assertions.assertEquals(flightRecord.getPaymentMethod(), flightInfo.getPaymentMethod(), "The payment method matches");
    }

    @Test
    public void deleteFlight() {
        // GIVEN
        FlightInfo flightInfo = new FlightInfo(name, email, flightId, originZipcode, destinationZipcode, numOfPassengers, paymentMethod);
        ArgumentCaptor<FlightRecord> flightRecordCaptor = ArgumentCaptor.forClass(FlightRecord.class);

        // WHEN
        flightService.deleteFlight(flightId);

        // THEN
        verify(flightRepository).delete(flightRecordCaptor.capture());

        FlightRecord flightRecord = flightRecordCaptor.getValue();

        Assertions.assertNotNull(flightRecord, "The flight record is returned");
        Assertions.assertNotNull(flightInfo, "The flight info is returned");
        Assertions.assertEquals(flightRecord.getFlightId(), flightInfo.getFlightId(), "The flightId matches");

    }

}
