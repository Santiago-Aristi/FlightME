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

    private String name;
    private String email;
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


    public void setOriginZipcode(OriginZip originZipcode) {
        this.originZipcode = originZipcode;
    }

    @DynamoDBAttribute(attributeName = "destinationZipCode")
    public DestinationZip getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(DestinationZip destinationZipcode) {
        this.destinationZipcode = destinationZipcode;
    }

    @DynamoDBAttribute(attributeName = "paymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
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

    //TODO: need to figure out how to implement a list to return all flights!!!!!!!!!!!!!!!!

//    public List<FlightInfo> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(List<FlightInfo> flights) {
//        this.flights = flights;
//    }
}
