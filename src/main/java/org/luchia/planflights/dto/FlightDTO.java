package org.luchia.planflights.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FlightDTO {
    private Long id;
    private int duration;
    private double price;
    private LocalDate date;
    private Long destination_id;
    private String destination;
    private Long airline_id;
    private String airline;

    public FlightDTO(Long id, int duration, double price, LocalDate date, Long destination_id, String destination_name, Long airline_id, String airline_name) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.date = date;
        this.destination_id = destination_id;
        this.destination = destination_name;
        this.airline_id = airline_id;
        this.airline = airline_name;
    }
}
