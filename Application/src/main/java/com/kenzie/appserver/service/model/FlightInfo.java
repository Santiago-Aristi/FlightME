package com.kenzie.appserver.service.model;

import java.util.Objects;

public class FlightInfo {
    private String flightId;
    private Quote quote;
    private OriginZip originZip;

    private DestinationZip destinationZip;
    private String paymentMethod;

    public FlightInfo(String flightId, OriginZip originZip, DestinationZip destinationZip, String paymentMethod){
        this.flightId = flightId;
        this.originZip = originZip;
        this.destinationZip = destinationZip;
        this.paymentMethod = paymentMethod;
    }

    public FlightInfo() {

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
                Objects.equals(originZip, that.originZip) && Objects.equals(destinationZip, that.destinationZip)
                && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, quote, originZip, destinationZip, paymentMethod);
    }
}
