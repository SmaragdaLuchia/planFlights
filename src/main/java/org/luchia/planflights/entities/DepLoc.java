package org.luchia.planflights.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "departure_location")
public class DepLoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @JsonIgnore
    @OneToMany(mappedBy = "departureLocation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Flight> flights;

}
