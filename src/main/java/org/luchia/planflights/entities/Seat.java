package org.luchia.planflights.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.query.Param;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seatNr")
    private int seatNr;

    @Column(name = "byWindow")
    private boolean byWindow;

    @Column(name = "nearExit")
    private boolean nearExit;

    @Column(name = "moreLegRoom")
    private boolean moreLegRoom;

    @Column(name = "class")
    private String classType;

    @Column(name = "occupied")
    private boolean occupied;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
