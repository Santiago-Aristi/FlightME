package com.kenzie.appserver.repositories;

import com.kenzie.appserver.service.model.FlightInfo;
import com.kenzie.appserver.service.model.Location;
import com.kenzie.appserver.service.model.Quote;
import com.kenzie.appserver.service.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRepository {
    List<Location> locationsList;
    List<UserInfo> usersList;
    List<Quote> quoteList;
    List<FlightInfo> flightList;

    public FlightRepository() {
        Location location = new Location();
        location.setOriginZipcode("12345");
        location.setDestinationZipcode("54321");

        locationsList = new ArrayList<>();
        locationsList.add(location);

        UserInfo userInfo = new UserInfo();
        userInfo.setName("Bobby Johnson");
        userInfo.setUserId("this is a fake ID");
        userInfo.setLocation(locationsList);
        userInfo.setEmail("bobby@gmail.com");
        userInfo.setPaymentMethod("credit card");

        usersList = new ArrayList<UserInfo>();
        usersList.add(userInfo);

        Quote quote = new Quote();
        quote.setFlightId("1234567");
        quote.setCargoType("A passenger");
        quote.setQuoteId("This is the quote Id");
        quote.setTotalCost(100.00);

        quoteList = new ArrayList<Quote>();
        quoteList.add(quote);

        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setFlightId("1234567");
        flightInfo.setUser(userInfo);
        flightInfo.setQuote(quote);
        flightInfo.setLocation(location);

        flightList = new ArrayList<>();
        flightList.add(flightInfo);

    }
}
