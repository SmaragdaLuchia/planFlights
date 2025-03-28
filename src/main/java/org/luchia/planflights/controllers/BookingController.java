package org.luchia.planflights.controllers;

import lombok.RequiredArgsConstructor;
import org.luchia.planflights.entities.Seat;
import org.luchia.planflights.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookFlight")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/{flightId}/seats")
    public ResponseEntity<List<Seat>> getSeats(@PathVariable Long flightId) {
        List<Seat> seats = bookingService.getSeats(flightId);
        return seats.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(seats);
    }

    @GetMapping("/{flightId}/suggestedSeats")
    public ResponseEntity<List<Seat>> getSuggestedSeats(
            @PathVariable Long flightId,
            @RequestParam(required = false) Boolean occupied,
            @RequestParam(required = false) Boolean byWindow,
            @RequestParam(required = false) Boolean nearExit,
            @RequestParam(required = false) Boolean moreLegRoom,
            @RequestParam(required = false) String classType

    ) {
        List<Seat> seats = bookingService.getSuggestedSeats(occupied, byWindow, nearExit, moreLegRoom, classType, flightId);
        return seats.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(seats);
    }

    @PostMapping("/{flightId}/occupySeat/{seatNr}")
    public ResponseEntity<?> occupySeat(@PathVariable Long flightId, @PathVariable int seatNr) {
        bookingService.occupySeat(seatNr);
        return ResponseEntity.ok().build();
    }


}
