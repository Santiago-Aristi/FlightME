package com.kenzie.appserver.repositories.model;

import com.kenzie.appserver.service.model.FlightInfo;
import com.kenzie.appserver.service.model.Location;

import java.util.List;

public class FlightRecord {

    private String flightId;
    private List<FlightInfo> flights;
    private Location location;
    private String paymentMethod;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    //TODO: need to figure out how to implement a list to return all flights!!!!!!!!!!!!!!!!

//    public List<FlightInfo> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(List<FlightInfo> flights) {
//        this.flights = flights;
//    }
}
