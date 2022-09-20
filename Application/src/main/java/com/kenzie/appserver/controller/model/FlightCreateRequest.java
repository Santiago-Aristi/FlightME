package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.Location;
import com.kenzie.appserver.service.model.Quote;
import com.kenzie.appserver.service.model.UserInfo;

import javax.validation.constraints.NotEmpty;

public class FlightCreateRequest {

    @NotEmpty
    @JsonProperty
    private String flightId;

    @NotEmpty
    @JsonProperty
    private UserInfo user;

    @NotEmpty
    @JsonProperty
    private Quote quote;

    @NotEmpty
    @JsonProperty
    private Location location;

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
}
