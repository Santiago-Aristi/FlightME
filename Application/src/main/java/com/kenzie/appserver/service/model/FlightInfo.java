package com.kenzie.appserver.service.model;

import com.kenzie.appserver.service.model.Location;
import com.kenzie.appserver.service.model.Quote;
import com.kenzie.appserver.service.model.UserInfo;

import java.util.Objects;

public class FlightInfo {
    private String flightId;
    private UserInfo user;
    private Quote quote;
    private Location location;
    private String paymentMethod;

    public FlightInfo(){

    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
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
        return Objects.equals(flightId, flight.flightId) && Objects.equals(user, flight.user) && Objects.equals(quote, flight.quote) && Objects.equals(location, flight.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, user, quote, location);
    }

}
