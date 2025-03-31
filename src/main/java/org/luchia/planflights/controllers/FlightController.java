package org.luchia.planflights.controllers;

import lombok.RequiredArgsConstructor;
import org.hibernate.grammars.hql.HqlParser;
import org.luchia.planflights.dto.FlightDTO;
import org.luchia.planflights.entities.Airline;
import org.luchia.planflights.entities.Destination;
import org.luchia.planflights.entities.Flight;
import org.luchia.planflights.services.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<FlightDTO>> getFlights() {
        List<FlightDTO> flights = flightService.getFlights();
        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> getFilteredFlights(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String airline,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String duration,
            @RequestParam(required = false) String price) {
        
        List<FlightDTO> flights = flightService.getFilteredFlights(destination, airline, date, duration, price);
        return flights.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(flights);
    }

    @GetMapping("/destinations")
    public ResponseEntity<List<Destination>> getDestinations() {
        List<Destination> destinations = flightService.getAllDestinations();
        return destinations.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(destinations);
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAirlines() {
        List<Airline> airlines = flightService.getAllAirlines();
        return airlines.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(airlines);
    }

    @GetMapping("/getFlight/{flightId}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long flightId) {
        FlightDTO flight = flightService.getFlightById(flightId);
        if (flight == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flight);
        }
    }

}
