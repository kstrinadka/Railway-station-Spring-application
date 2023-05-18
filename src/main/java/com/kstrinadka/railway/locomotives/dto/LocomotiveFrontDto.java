package com.kstrinadka.railway.locomotives.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocomotiveFrontDto {
    private Long locomotiveid;
    private Long stationid;
    private Long birthday;
    private Long locomotivebrigadeid;
    private Long repairmenbrigadeid;
    private Long numberofroutes;
    private Long seatsnumber;
}
