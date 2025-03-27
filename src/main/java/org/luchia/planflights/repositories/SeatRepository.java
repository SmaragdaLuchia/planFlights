package org.luchia.planflights.repositories;

import jakarta.transaction.Transactional;
import org.luchia.planflights.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value = """
    SELECT 
        id, 
        seatNr as seat_nr, 
        byWindow as by_window, 
        nearExit as near_exit, 
        moreLegRoom as more_leg_room, 
        class, 
        occupied, 
        flight_id 
    FROM seats 
    WHERE flight_id = :flightId""",
            nativeQuery = true)
    List<Seat> findAllSeatsByFlight(Long flightId);



    @Query(value = """
    SELECT 
        id, 
        seatNr as seat_nr, 
        byWindow as by_window, 
        nearExit as near_exit, 
        moreLegRoom as more_leg_room, 
        class, 
        occupied, 
        flight_id
    FROM seats
    WHERE (:occupied IS NULL OR occupied = :occupied)
      AND (:byWindow IS NULL OR byWindow = :byWindow)
      AND (:nearExit IS NULL OR nearExit = :nearExit)
      AND (:moreLegRoom IS NULL OR moreLegRoom = :moreLegRoom)
      AND (:classType IS NULL OR class = :classType)
      AND flight_id = :flightId
    """, nativeQuery = true)
    List<Seat> suggestSeats(
            @Param("occupied") Boolean occupied,
            @Param("byWindow") Boolean byWindow,
            @Param("nearExit") Boolean nearExit,
            @Param("moreLegRoom") Boolean moreLegRoom,
            @Param("classType") String classType,
            @Param("flightId") Long flightId
    );

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE seats s
    SET occupied = true
    WHERE s.seatNr = :seatNr
    """, nativeQuery = true)
    void occupySeat(@Param("seatNr") int seatNr);

}
