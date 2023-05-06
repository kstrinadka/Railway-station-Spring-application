package com.kstrinadka.railway.tickets;


import com.kstrinadka.railway.flights.Flight;
import com.kstrinadka.railway.passengers.Passenger;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketid", nullable = false)
    private Long ticketid;

    @ManyToOne
    @JoinColumn (name = "passengerpassport", referencedColumnName = "passportnumber", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn (name = "flightnumber", referencedColumnName = "flightnumber", nullable = false)
    private Flight flight;

    private Long cost;

    private LocalDateTime timepurchase;

    private Boolean packing;

    private Boolean returnticket;

    private Date returndate;

}
