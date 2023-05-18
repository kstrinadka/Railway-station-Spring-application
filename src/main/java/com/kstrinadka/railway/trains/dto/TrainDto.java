package com.kstrinadka.railway.trains.dto;


import com.kstrinadka.railway.locomotives.dto.LocomotiveDto;
import com.kstrinadka.railway.trains.Train;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Train} entity
 */
@Data
@NoArgsConstructor
public class TrainDto {
    private Long trainnumber;
    private String typetrain;
    private LocomotiveDto locomotive;
}
