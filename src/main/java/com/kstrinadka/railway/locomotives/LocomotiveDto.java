package com.kstrinadka.railway.locomotives;


import com.kstrinadka.railway.brigades.BrigadeDto;
import com.kstrinadka.railway.stationsAndRoutes.dto.StationDto;
import com.kstrinadka.railway.stationsAndRoutes.model.Station;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.locomotives.model.Locomotive} entity
 */
@Data
@NoArgsConstructor
public class LocomotiveDto {
    private Long locomotiveid;
    private StationDto station;
    private Long birthday;
    private BrigadeDto locomotivebrigade;
    private BrigadeDto repairmenbrigade;
    private Long numberofroutes;
    private Long seatsnumber;
}
