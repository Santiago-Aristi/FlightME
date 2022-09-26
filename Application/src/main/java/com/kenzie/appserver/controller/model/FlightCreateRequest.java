package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.OriginZip;

import javax.validation.constraints.NotEmpty;

public class FlightCreateRequest {

    @NotEmpty
    @JsonProperty
    private String name;

    @NotEmpty
    @JsonProperty
    private String email;

//    @NotEmpty
//    @JsonProperty
//    private String flightId;

    @NotEmpty
    @JsonProperty
    private String originZipcode;

    @NotEmpty
    @JsonProperty
    private String destinationZipcode;

    @NotEmpty
    @JsonProperty
    private Integer numOfPassengers;

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

//    public String getFlightId() {
//        return flightId;
//    }
//
//    public void setFlightId(String flightId) {
//        this.flightId = flightId;
//    }

    public String getOriginZipcode() {
        return originZipcode;
    }

    public void setOriginZipcode(String originZip) {
        this.originZipcode = originZipcode;
    }

    public String getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(String destinationZipcode) {
        this.destinationZipcode = destinationZipcode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(Integer numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}


