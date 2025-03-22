package org.luchia.planflights.controllers;

import lombok.RequiredArgsConstructor;
import org.luchia.planflights.dto.FlightDTO;
import org.luchia.planflights.entities.Flight;
import org.luchia.planflights.services.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
