package com.kenzie.appserver.service.model;

public class FlightInfo {
    private final String flightId;
    private final String name;
    private final String email;
    private final String originZipcode;
    private final String destinationZipcode;
    private final Integer numOfPassengers;
    private final String paymentMethod;
    private final Integer rate;

    public FlightInfo(String flightId, String name, String email, String originZipcode,
                      String destinationZipcode, Integer numOfPassengers, String paymentMethod, Integer rate){
        this.flightId = flightId;
        this.name = name;
        this.email = email;
        this.originZipcode = originZipcode;
        this.destinationZipcode = destinationZipcode;
        this.numOfPassengers = numOfPassengers;
        this.paymentMethod = paymentMethod;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getOriginZipcode() {
        return originZipcode;
    }

    public String getDestinationZipcode() {
        return destinationZipcode;
    }

    public Integer getNumOfPassengers() {
        return numOfPassengers;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public Integer getRate() {
        return this.rate;
    }

}
