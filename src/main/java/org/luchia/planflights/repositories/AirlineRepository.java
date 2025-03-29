package org.luchia.planflights.repositories;

import org.luchia.planflights.entities.Airline;
import org.luchia.planflights.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    @Query("SELECT a FROM Airline a")
    List<Airline> getAllAirlines();
}
