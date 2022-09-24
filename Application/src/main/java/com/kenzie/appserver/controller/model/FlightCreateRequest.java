package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.OriginZip;
import com.kenzie.appserver.service.model.Quote;

import javax.validation.constraints.NotEmpty;

public class FlightCreateRequest {

    @NotEmpty
    @JsonProperty
    private String name;

    @NotEmpty
    @JsonProperty
    private String email;

    @NotEmpty
    @JsonProperty
    private String flightId;

    @NotEmpty
    @JsonProperty
    private Quote quote;

    @NotEmpty
    @JsonProperty
    private OriginZip originZipcode;

    @NotEmpty
    @JsonProperty
    private DestinationZip destinationZipcode;

    @NotEmpty
    @JsonProperty
    private String paymentMethod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public OriginZip getOriginZipcode() {
        return originZipcode;
    }

    public void setOriginZipcode(OriginZip originZip) {
        this.originZipcode = originZipcode;
    }

    public DestinationZip getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(DestinationZip destinationZipcode) {
        this.destinationZipcode = destinationZipcode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}


