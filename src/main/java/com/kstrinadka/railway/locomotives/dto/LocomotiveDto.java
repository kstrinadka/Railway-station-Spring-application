package com.kstrinadka.railway.locomotives.dto;


import com.kstrinadka.railway.brigades.BrigadeDto;
import com.kstrinadka.railway.stations.StationDto;
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
