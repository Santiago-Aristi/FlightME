package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.OriginZip;
import com.kenzie.appserver.service.model.Quote;

import javax.validation.constraints.NotEmpty;

public class FlightCreateRequest {

    @NotEmpty
    @JsonProperty
    private String flightId;


    @NotEmpty
    @JsonProperty
    private Quote quote;

    @NotEmpty
    @JsonProperty
    private OriginZip originZip;

    @NotEmpty
    @JsonProperty
    private DestinationZip destinationZip;

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

    public OriginZip getOriginZip() {
        return originZip;
    }

    public void setOriginZip(OriginZip originZip) {
        this.originZip = originZip;
    }

    public DestinationZip getDestinationZip() {
        return destinationZip;
    }

    public void setDestinationZip(DestinationZip destinationZip) {
        this.destinationZip = destinationZip;
    }
}


