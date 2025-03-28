package org.luchia.planflights.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "duration")
    private int duration;
    @Column(name = "price")
    private double price;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "dep_time")
    private LocalTime depTime;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @JsonIgnore
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "dep_loc_id")
    private DepLoc departureLocation;

}
