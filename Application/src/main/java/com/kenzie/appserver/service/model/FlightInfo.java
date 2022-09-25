package com.kenzie.appserver.service.model;

import java.util.Objects;

public class FlightInfo {
    private String name;
    private String email;
    private String flightId;
    private OriginZip originZipcode;
    private DestinationZip destinationZipcode;
    private Integer numOfPassengers;
    private String paymentMethod;

    public FlightInfo(String name, String email, String flightId, OriginZip originZipcode, DestinationZip destinationZipcode, Integer numOfPassengers, String paymentMethod){
        this.name = name;
        this.email = email;
        this.flightId = flightId;
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

    public OriginZip getOriginZipcode() {
        return originZipcode;
    }

    public void setOriginZipcode(OriginZip originZipcode) {
        this.originZipcode = originZipcode;
    }

    public DestinationZip getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(DestinationZip destinationZipcode) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightInfo that = (FlightInfo) o;
        return name.equals(that.name) && email.equals(that.email) && flightId.equals(that.flightId) && originZipcode.equals(that.originZipcode) && destinationZipcode.equals(that.destinationZipcode) && numOfPassengers.equals(that.numOfPassengers) && paymentMethod.equals(that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, flightId, originZipcode, destinationZipcode, numOfPassengers, paymentMethod);
    }
}
