package com.kstrinadka.railway.model;


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

    private Long passengerpassport;

    private Long flightnumber;

    private Long cost;

    private LocalDateTime timepurchase;

    private Boolean packing;

    private Boolean returnticket;

    private LocalDateTime returndate;

}
