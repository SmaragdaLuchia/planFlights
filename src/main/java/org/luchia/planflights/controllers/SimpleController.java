package org.luchia.planflights.controllers;

import org.luchia.planflights.repositories.FlightRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    private final FlightRepository flightRepository;

    public SimpleController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/") //<--- This means, that when the request goes to the root of our website, next method will be called
    public String index() {
        flightRepository.findByAirlineId(2L).forEach(flight -> System.out.println(flight.getPrice()));
        return "index.html";
    }
}
