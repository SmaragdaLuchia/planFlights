package org.luchia.planflights;

import org.luchia.planflights.entities.Flight;
import org.luchia.planflights.repositories.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PlanFlightsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PlanFlightsApplication.class, args);

        var flightRepository = context.getBean(FlightRepository.class);
        var flight = flightRepository.findById(1L).orElse(null);
        System.out.println(flight.getPrice());
    }
}
