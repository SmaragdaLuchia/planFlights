package org.luchia.planflights.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class FlightDTO {
    private Long id;
    private int duration;
    private double price;
    private LocalDate date;
    private Long destination_id;
    private String destination_name;
    private String destination_region;
    private Long airline_id;
    private String airline;
    private LocalTime depTime;
    private Long depLoc_id;
    private String depLoc_name;
    private String deploc_region;



    public FlightDTO(Long id, int duration, double price, LocalDate date, Long destination_id, String destination_name, String destination_region, Long airline_id, String airline_name, LocalTime depTime, Long depLoc_id, String depLoc_name, String deploc_region) {
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.date = date;
        this.destination_id = destination_id;
        this.destination_name = destination_name;
        this.airline_id = airline_id;
        this.airline = airline_name;
        this.depTime = depTime;
        this.depLoc_id = depLoc_id;
        this.depLoc_name = depLoc_name;
        this.deploc_region = deploc_region;
    }
}
