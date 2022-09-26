package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.kenzie.appserver.service.model.DestinationZip;
import com.kenzie.appserver.service.model.FlightInfo;
import com.kenzie.appserver.service.model.OriginZip;

import java.util.List;
import java.util.Objects;

@DynamoDBTable(tableName = "Flights")
public class FlightRecord {

    private String name;
    private String email;
    private String flightId;
    private String originZipcode;
    private String destinationZipcode;
    private Integer numOfPassengers;
    private String paymentMethod;

    @DynamoDBHashKey(attributeName = "flightId")
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @DynamoDBAttribute(attributeName = "originZipCode")
    public String getOriginZipcode() {
        return originZipcode;
    }


    public void setOriginZipcode(String originZipcode) {
        this.originZipcode = originZipcode;
    }

    @DynamoDBAttribute(attributeName = "destinationZipCode")
    public String getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(String destinationZipcode) {
        this.destinationZipcode = destinationZipcode;
    }

    @DynamoDBAttribute(attributeName = "paymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "numOfPassengers")
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
        FlightRecord that = (FlightRecord) o;
        return flightId.equals(that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId);
    }

}