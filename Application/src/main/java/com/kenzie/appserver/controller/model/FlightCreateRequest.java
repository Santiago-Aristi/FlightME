package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;

public class FlightCreateRequest {

    @NotEmpty
    @JsonProperty("name")
    private String name;

    @NotEmpty
    @JsonProperty("email")
    private String email;

    @NotEmpty
    @JsonProperty("originZipcode")
    private String originZipcode;

    @NotEmpty
    @JsonProperty("destinationZipcode")
    private String destinationZipcode;

    @NotEmpty
    @JsonProperty("numOfPassengers")
    private String numOfPassengers;

    @NotEmpty
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

    public String getOriginZipcode() {
        return originZipcode;
    }

    public void setOriginZipcode(String originZipcode) {
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

    public String getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(String numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }
}


