package com.kstrinadka.railway.flights;


import com.kstrinadka.railway.trains.Train;
import com.kstrinadka.railway.stationsAndRoutes.model.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Сущность поездки
 */
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "timetable")
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flightnumber", nullable = false)
    private Long flightnumber;

    @ManyToOne
    @JoinColumn(name = "trainnumber", referencedColumnName = "trainnumber", nullable = false)
    private Train train;

    private Timestamp departure;

    private Timestamp arrival;

    @ManyToOne
    @JoinColumn(name = "routenumber", referencedColumnName = "routenumber", nullable = false)
    private Route route;

    private Boolean cancel;

    private String reasoncancellation;

    private Time timedelay;

    private Boolean delay;
}
