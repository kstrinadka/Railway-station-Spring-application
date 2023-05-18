package com.kstrinadka.railway.flights.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class FlightFrontDto {
    private Long flightnumber;
    private Long trainnumber;
    private Timestamp departure;
    private Timestamp arrival;
    private Long routenumber;
    private Boolean cancel;
    private String reasoncancellation;
    private Time timedelay;
    private Boolean delay;
}
