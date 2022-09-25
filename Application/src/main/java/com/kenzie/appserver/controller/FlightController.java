package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.FlightCreateRequest;
import com.kenzie.appserver.controller.model.FlightResponse;
import com.kenzie.appserver.service.FlightService;
import com.kenzie.appserver.service.model.FlightInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightCreateRequest flightCreateRequest) {
        FlightInfo flightInfo = new FlightInfo(flightCreateRequest.getName(),
                flightCreateRequest.getEmail(),
                flightCreateRequest.getFlightId(),
                flightCreateRequest.getOriginZipcode(),
                flightCreateRequest.getDestinationZipcode(),
                flightCreateRequest.getNumOfPassengers(),
                flightCreateRequest.getPaymentMethod());

        flightService.createFlight(flightInfo);

        FlightResponse flightResponse = createFlightResponse(flightInfo);

        return ResponseEntity.created(URI.create("/flight/" + flightResponse.getFlightId())).body(flightResponse);
    }

    @GetMapping("/all/")
    public ResponseEntity<List<FlightResponse>> getAllFlightsForUser() {
        List<FlightInfo> allFlights = flightService.getAllFlights();

        if (allFlights.isEmpty() || allFlights == null) {
            return ResponseEntity.noContent().build();
        }

        List<FlightResponse> flightList = new ArrayList<>();
        for (FlightInfo flight : allFlights) {
            flightList.add(this.createFlightResponse(flight));
        }
        return ResponseEntity.ok(flightList);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponse> getFlight(@PathVariable("flightId") String flightId) {
        FlightInfo flightInfo = flightService.getFlight(flightId);

        if (flightInfo == null) {
            return ResponseEntity.noContent().build();
        }

        FlightResponse flightResponse = createFlightResponse(flightInfo);
        return ResponseEntity.ok(flightResponse);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity deleteFlight(@PathVariable("flightId") String flightId) {

        if (flightId == null) {
            return ResponseEntity.noContent().build();
        }

        flightService.deleteFlight(flightId);

        return ResponseEntity.noContent().build();
    }

    public FlightResponse createFlightResponse(FlightInfo flightInfo) {
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setName(flightInfo.getName());
        flightResponse.setEmail(flightInfo.getEmail());
        flightResponse.setFlightId(flightInfo.getFlightId());
        flightResponse.setOriginZip(flightInfo.getOriginZipcode());
        flightResponse.setDestinationZip(flightInfo.getDestinationZipcode());
        flightResponse.setNumOfPassengers(flightInfo.getNumOfPassengers());
        flightResponse.setPaymentMethod(flightInfo.getPaymentMethod());

        return flightResponse;
    }
}
