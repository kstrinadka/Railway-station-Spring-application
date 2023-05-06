package com.kstrinadka.railway.stationsAndRoutes.dto;



import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.stationsAndRoutes.model.Station} entity
 */
@Data
@NoArgsConstructor
public class StationDto {
    private Long stationid;

    private String stationname;
}
