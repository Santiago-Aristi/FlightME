package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.Location;
import com.kenzie.appserver.service.model.Quote;
import com.kenzie.appserver.service.model.UserInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponse {

    @JsonProperty("flightId")
    private String flightId;

    @JsonProperty("userId")
    private UserInfo user;

    @JsonProperty("quote")
    private Quote quote;

    @JsonProperty("location")
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
