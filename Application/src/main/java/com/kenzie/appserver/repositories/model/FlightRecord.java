package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.FlightInfo;
import com.kenzie.appserver.service.model.OriginZip;

import java.util.List;

@DynamoDBTable(tableName = "Flights")
public class FlightRecord {

    private String flightId;
    private List<FlightInfo> flights;
    private OriginZip originZipcode;
    private DestinationZip destinationZipcode;
    private String paymentMethod;

    @DynamoDBHashKey(attributeName = "flightId")
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @DynamoDBAttribute(attributeName = "originZipCode")
    public OriginZip getOriginZipcode() {
        return originZipcode;
    }

    @DynamoDBAttribute(attributeName = "destinationZipCode")
    public DestinationZip getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setOriginZipcode(OriginZip originZipcode) {
        this.originZipcode = originZipcode;
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

    //TODO: need to figure out how to implement a list to return all flights!!!!!!!!!!!!!!!!

//    public List<FlightInfo> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(List<FlightInfo> flights) {
//        this.flights = flights;
//    }
}
