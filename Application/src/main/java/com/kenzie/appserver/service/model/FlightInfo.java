package com.kenzie.appserver.service.model;

import com.kenzie.appserver.service.model.Location;
import com.kenzie.appserver.service.model.Quote;
import com.kenzie.appserver.service.model.UserInfo;

import java.util.Objects;

public class FlightInfo {
    private String flightId;
    private Quote quote;
    private Location location;
    private String paymentMethod;

    public FlightInfo(String flightId, Location location, String paymentMethod){
        this.flightId = flightId;
        this.location = location;
        this.paymentMethod = paymentMethod;
    }

    public FlightInfo() {

    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPaymentMethod(){

    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightInfo flight = (FlightInfo) o;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(quote, flight.quote) && Objects.equals(location, flight.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, quote, location);
    }

}
