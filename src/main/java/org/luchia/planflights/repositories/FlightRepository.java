package org.luchia.planflights.repositories;
import org.luchia.planflights.dto.FlightDTO;
import org.luchia.planflights.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

import java.util.List;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT new org.luchia.planflights.dto.FlightDTO(f.id, f.duration, f.price, f.date, d.id, d.name, a.id, a.name) " +
            "FROM Flight f " +
            "JOIN f.destination d " +
            "JOIN f.airline a"
    )
    List<FlightDTO> findAllFlights();

    @Query("SELECT new org.luchia.planflights.dto.FlightDTO(f.id, f.duration, f.price, f.date, d.id, d.name, a.id, a.name) " +
            "FROM Flight f " +
            "JOIN f.destination d " +
            "JOIN f.airline a " +
            "WHERE (:destination IS NULL OR d.name = :destination) " +
            "AND (:airline IS NULL OR a.name = :airline) " +
            "AND (:date IS NULL OR f.date = :date) " +
            "AND (:price IS NULL OR f.price <= :price) " +
            "AND (:duration IS NULL OR f.duration <= :duration)")
    Set<FlightDTO> findFlightsByFilters(
            @Param("destination") String destination,
            @Param("airline") String airline,
            @Param("date") LocalDate date,
            @Param("price") Double price,
            @Param("duration") Integer duration
    );

}
