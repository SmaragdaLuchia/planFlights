package org.luchia.planflights;

import org.luchia.planflights.entities.Flight;
import org.luchia.planflights.repositories.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PlanFlightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanFlightsApplication.class, args);
    }
}
