package com.kstrinadka.railway.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;


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

    @Column(name = "trainnumber", nullable = false)
    private Long trainnumber;

    @Column(name = "departure", nullable = false)
    private Date departure;

    @Column(name = "arrival", nullable = false)
    private Date arrival;

    @Column(name = "routenumber", nullable = false)
    private Long routenumber;

    private Boolean cancel;

    @Column(name = "reasoncancellation", nullable = false)
    private String reasoncancellation;

    private Time timedelay;

    @Column(name = "delay", nullable = false)
    private Boolean delay;

}
