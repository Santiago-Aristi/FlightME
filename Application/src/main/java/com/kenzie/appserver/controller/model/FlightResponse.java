package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.OriginZip;
import com.kenzie.appserver.service.model.Quote;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponse {

    @JsonProperty("flightId")
    private String flightId;

    @JsonProperty("quote")
    private Quote quote;

    @JsonProperty("originZip")
    private OriginZip originZip;

    @JsonProperty("destinationZip")
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
