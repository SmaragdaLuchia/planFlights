package org.luchia.planflights.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.luchia.planflights.entities.Seat;
import org.luchia.planflights.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingService {

    private final SeatRepository seatRepository;


    public List<Seat> getSeats(Long flightId) {
        return seatRepository.findAllSeatsByFlight(flightId);
    }

    public List<Seat> getSuggestedSeats(Boolean occupied, Boolean byWindow, Boolean nearExit, Boolean moreLegRoom, String classType, Long flightId) {
        return seatRepository.suggestSeats(occupied, byWindow, nearExit, moreLegRoom, classType, flightId);
    }

    @Transactional
    public void occupySeat(int seatNr) {
        seatRepository.occupySeat(seatNr);
    }

}
