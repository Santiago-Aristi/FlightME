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

    FlightController (FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightCreateRequest flightCreateRequest){
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setFlightId(flightCreateRequest.getFlightId());
        flightInfo.setLocation(flightCreateRequest.getLocation());
        flightInfo.setUser(flightCreateRequest.getUser());
        flightInfo.setQuote(flightCreateRequest.getQuote());
        flightService.createFlight(flightInfo);

        FlightResponse flightResponse = createFlightResponse(flightInfo);

        return ResponseEntity.created(URI.create("/flight/" + flightResponse.getFlightId())).body(flightResponse);
    }

    @GetMapping("/all/user/{userId}")
    public ResponseEntity<List<FlightResponse>> getAllFlightsForUser(@PathVariable String userId){
        List<FlightInfo> allFlights = flightService.getAllFlights(userId);

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
    public ResponseEntity<FlightResponse> getFlight(@PathVariable String flightId){
        FlightInfo flightInfo = flightService.getFlight(flightId);

        if (flightInfo == null) {
            return ResponseEntity.noContent().build();
        }

        FlightResponse flightResponse = createFlightResponse(flightInfo);
        return ResponseEntity.ok(flightResponse);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<FlightResponse> deleteFlight(@PathVariable String flightId){

        FlightInfo flightInfo = flightService.deleteFlight(flightId);

        if (flightInfo == null) {
            return ResponseEntity.noContent().build();
        }

        FlightResponse flightResponse = createFlightResponse(flightInfo);
        return ResponseEntity.ok(flightResponse);
    }

    public FlightResponse createFlightResponse(FlightInfo flightInfo) {
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setFlightId(flightInfo.getFlightId());
        flightResponse.setUser(flightInfo.getUser());
        flightResponse.setQuote(flightInfo.getQuote());
        flightResponse.setLocation(flightInfo.getLocation());

        return flightResponse;
    }
}
