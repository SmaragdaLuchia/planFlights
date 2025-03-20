package org.luchia.planflights.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "region")
    private String region;

    @OneToMany(mappedBy = "destination")
    private Set<Flight> flights = new HashSet<>();
}
