package com.kenzie.appserver;

public class FlightNotFoundException extends RuntimeException {

    public FlightNotFoundException(String id){
        super("Could not find flight " + id);
    }
}
