package org.luchia.planflights.repositories;

import org.luchia.planflights.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    @Query("SELECT d FROM Destination d")
    List<Destination> getAllDestinations();
}
