package org.luchia.planflights.services;

import org.luchia.planflights.dto.FlightDTO;
import org.luchia.planflights.entities.Flight;
import org.luchia.planflights.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public List<FlightDTO> getFlights() {
        return flightRepository.findAllFlights();
    }

    public List<FlightDTO> getFilteredFlights(String destination, String airline, String date, String duration, String price) {
        //Parse data
        LocalDate correctDate;
        if (date != null) {
            correctDate = LocalDate.parse(date);
        } else {
            correctDate = null;
        }

        Double correctPrice;
        if (price != null) {
                correctPrice = Double.parseDouble(price);
        } else {
            correctPrice = null;
        }

        Integer correctDuration = null;
        if (duration != null) {
                correctDuration = Integer.parseInt(duration);
        }

        //Adding two lists of flights together
        Set<FlightDTO> flights = flightRepository.findFlightsByFilters(destination, airline, correctDate, correctPrice, correctDuration);
        
        return new ArrayList<>(flights);
    }
}
