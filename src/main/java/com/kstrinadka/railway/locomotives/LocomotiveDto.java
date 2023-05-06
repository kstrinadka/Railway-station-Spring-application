package com.kstrinadka.railway.locomotives;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.kstrinadka.railway.locomotives.model.Locomotive} entity
 */
@Data
@NoArgsConstructor
public class LocomotiveDto {
    private Long locomotiveid;
    private Long stationid;
    private Long birthday;
    private Long locomotivebrigadeid;
    private Long repairmenbrigadeid;
    private Long numberofroutes;
    private Long seatsnumber;
}
