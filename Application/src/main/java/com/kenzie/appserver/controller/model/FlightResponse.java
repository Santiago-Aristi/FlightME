package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.OriginZip;
import com.kenzie.appserver.service.model.Quote;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("flightId")
    private String flightId;

    @JsonProperty("originZip")
    private OriginZip originZip;

    @JsonProperty("destinationZip")
    private DestinationZip destinationZip;

    @JsonProperty("numOfPassengers")
    private Integer numOfPassengers;

    @JsonProperty("paymentMethod")
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

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(Integer numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
