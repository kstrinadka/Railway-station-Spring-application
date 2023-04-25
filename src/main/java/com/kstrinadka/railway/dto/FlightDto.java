package com.kstrinadka.railway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * A DTO for the {@link com.kstrinadka.railway.model.Flight} entity
 */
@Data
@NoArgsConstructor
public class FlightDto implements Serializable {
    private Long flightnumber;
    private Long trainnumber;
    private Date departure;
    private Date arrival;
    private Long routenumber;
    private Boolean cancel;
    private String reasoncancellation;
    private Time timedelay;
    private Boolean delay;
    private Boolean isRegistrationOpen;
}