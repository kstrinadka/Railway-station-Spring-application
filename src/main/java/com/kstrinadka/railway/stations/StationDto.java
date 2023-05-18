package com.kstrinadka.railway.stations;



import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Station} entity
 */
@Data
@NoArgsConstructor
public class StationDto {
    private Long stationid;

    private String stationname;
}
