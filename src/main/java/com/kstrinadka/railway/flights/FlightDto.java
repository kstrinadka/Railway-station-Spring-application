package com.kstrinadka.railway.flights;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * A DTO for the {@link Flight} entity
 */
@Data
@NoArgsConstructor
public class FlightDto implements Serializable {
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
