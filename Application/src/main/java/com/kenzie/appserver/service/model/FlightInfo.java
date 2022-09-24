package com.kenzie.appserver.service.model;

import java.util.Objects;

public class FlightInfo {
    private String name;
    private String email;
    private String flightId;
    private Quote quote;
    private OriginZip originZipcode;
    private DestinationZip destinationZipcode;
    private String paymentMethod;

    public FlightInfo(String name, String email, String flightId, OriginZip originZipcode, DestinationZip destinationZipcode, String paymentMethod){
        this.name = name;
        this.email = email;
        this.flightId = flightId;
        this.originZipcode = originZipcode;
        this.destinationZipcode = destinationZipcode;
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

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightInfo that = (FlightInfo) o;
        return Objects.equals(flightId, that.flightId) && Objects.equals(quote, that.quote) &&
                Objects.equals(originZipcode, that.originZipcode) && Objects.equals(destinationZipcode, that.destinationZipcode)
                && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, quote, originZipcode, destinationZipcode, paymentMethod);
    }
    //
}
