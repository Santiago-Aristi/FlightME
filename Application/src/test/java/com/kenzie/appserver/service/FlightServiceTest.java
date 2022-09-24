package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.FlightRepository;
import com.kenzie.appserver.repositories.model.FlightRecord;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.FlightInfo;
import com.kenzie.appserver.service.model.OriginZip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class FlightServiceTest {
    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @BeforeEach
    void setup() {
        flightRepository = mock(FlightRepository.class);
        flightService = new FlightService(flightRepository);
    }

    @Test
    public void getFlight_validInput_returnsValidFLights() {
        // GIVEN
        String flightId = UUID.randomUUID().toString();

        OriginZip originZipcode = new OriginZip();
        originZipcode.setOriginZipcode("12345");

        DestinationZip destinationZipcode = new DestinationZip();
        destinationZipcode.setDestinationZipcode("54321");

        FlightRecord flightRecord = new FlightRecord();
        flightRecord.setFlightId(flightId);
        flightRecord.setOriginZipcode(originZipcode);
        flightRecord.setDestinationZipcode(destinationZipcode);
        flightRecord.setPaymentMethod("Credit Card");

        // WHEN
        when(flightRepository.findById(flightId)).thenReturn(Optional.of(flightRecord));
        FlightInfo flightInfo = flightService.getFlight(flightId);

        Assertions.assertNotNull(flightInfo, "The flight is returned properly");
        Assertions.assertEquals(flightRecord.getFlightId(), flightInfo.getFlightId(), "Both id match");
        Assertions.assertEquals(flightRecord.getOriginZipcode(), flightInfo.getOriginZipcode(), "Both zip codes match");
        Assertions.assertEquals(flightRecord.getDestinationZipcode(), flightInfo.getDestinationZipcode(), "Both zip codes match");
        Assertions.assertEquals(flightRecord.getPaymentMethod(), flightInfo.getPaymentMethod(), "Both payments match");
    }

    @Test
    public void createFlight_validInput_CreatesValidFlight(){
        String name = "name";
        String email = "email";
        String flightId = UUID.randomUUID().toString();
        String paymentMethod = "Credit Card";

        OriginZip originZipcode = new OriginZip();
        originZipcode.setOriginZipcode("12345");

        DestinationZip destinationZipcode = new DestinationZip();
        destinationZipcode.setDestinationZipcode("54321");

        FlightInfo flightInfo = new FlightInfo(name, email, flightId, originZipcode, destinationZipcode, paymentMethod);

//        doNothing().when(flightRepository).findById(flightId);
        flightService.createFlight(flightInfo);


    }
}
