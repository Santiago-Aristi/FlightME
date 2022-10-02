package com.kenzie.appserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.FlightCreateRequest;
import com.kenzie.appserver.service.FlightService;
import com.kenzie.appserver.service.model.FlightInfo;
import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.UUID.randomUUID;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class FlightControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    FlightService flightService;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getById_Exists() throws Exception {
        String flightId = randomUUID().toString();
        String name = mockNeat.strings().valStr();
        String email = mockNeat.strings().valStr();
        String originZipcode = mockNeat.strings().valStr();
        String destinationZipcode = mockNeat.strings().valStr();
        String numOfPassengers = mockNeat.strings().valStr();
        String paymentMethod = mockNeat.strings().valStr();

        FlightInfo flightInfo = new FlightInfo(flightId, name, email, originZipcode, destinationZipcode, numOfPassengers, paymentMethod);
        FlightInfo persistedFlight = flightService.createFlight(flightInfo);
        this.mvc.perform(get("/flight/{flightId}", persistedFlight.getFlightId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("flightId")
                        .value(is(flightId)))
                .andExpect(jsonPath("name")
                        .value(is(name)))
                .andExpect(jsonPath("email")
                        .value(is(email)))
                .andExpect(jsonPath("originZipcode")
                        .value(is(originZipcode)))
                .andExpect(jsonPath("destinationZipcode")
                        .value(is(destinationZipcode)))
                .andExpect(jsonPath("numOfPassengers")
                        .value(is(numOfPassengers)))
                .andExpect(jsonPath("paymentMethod")
                        .value(is(paymentMethod)))
                .andExpect(status().isOk());
    }

    @Test
    public void createFlight_CreateSuccessful() throws Exception {
        String name = mockNeat.strings().valStr();
        String email = mockNeat.strings().valStr();
        String originZipcode = mockNeat.strings().valStr();
        String destinationZipcode = mockNeat.strings().valStr();
        String numOfPassengers = mockNeat.strings().valStr();
        String paymentMethod = mockNeat.strings().valStr();

        FlightCreateRequest flightCreateRequest = new FlightCreateRequest();
        flightCreateRequest.setName(name);
        flightCreateRequest.setEmail(email);
        flightCreateRequest.setOriginZipcode(originZipcode);
        flightCreateRequest.setDestinationZipcode(destinationZipcode);
        flightCreateRequest.setNumOfPassengers(numOfPassengers);
        flightCreateRequest.setPaymentMethod(paymentMethod);

        mapper.registerModule(new JavaTimeModule());

        this.mvc.perform(post("/flight")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(flightCreateRequest)))
                .andExpect(jsonPath("flightId")
                        .exists())
                .andExpect(jsonPath("name")
                        .value(is(name)))
                .andExpect(jsonPath("email")
                        .value(is(email)))
                .andExpect(jsonPath("originZipcode")
                        .value(is(originZipcode)))
                .andExpect(jsonPath("destinationZipcode")
                        .value(is(destinationZipcode)))
                .andExpect(jsonPath("numOfPassengers")
                        .value(is(numOfPassengers)))
                .andExpect(jsonPath("paymentMethod")
                        .value(is(paymentMethod)))
                .andExpect(status().isCreated());
    }
}
