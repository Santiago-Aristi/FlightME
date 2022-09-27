package com.kenzie.appserver.service.model;

public class FlightInfo {
    private String flightId;
    private String name;
    private String email;
    private String originZipcode;
    private String destinationZipcode;
    private Integer numOfPassengers;
    private String paymentMethod;

    public FlightInfo(String flightId, String name, String email, String originZipcode, String destinationZipcode, Integer numOfPassengers, String paymentMethod){
        this.flightId = flightId;
        this.name = name;
        this.email = email;
        this.originZipcode = originZipcode;
        this.destinationZipcode = destinationZipcode;
        this.numOfPassengers = numOfPassengers;
        this.paymentMethod = paymentMethod;
    }

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

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(Integer numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }


}
